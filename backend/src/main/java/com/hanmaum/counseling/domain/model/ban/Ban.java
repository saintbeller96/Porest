package com.hanmaum.counseling.domain.model.ban;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.error.BannedUserException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_user_id")
    private User banUser;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_report_id")
    private BanReport report;

    @Column(name = "ban_release_date")
    private LocalDateTime releaseDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Ban(User banUser, BanReport report, LocalDateTime releaseDate) {
        this.banUser = banUser;
        this.report = report;
        this.releaseDate = releaseDate;
    }

    public void validateBanExpired(LocalDateTime day){
        if(releaseDate.isAfter(day)){
            throw new BannedUserException("해당 계정은 정지된 상태입니다");
        }
    }
}
