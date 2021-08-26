package com.hanmaum.counseling.domain.ban;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.error.BannedUserException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private User banUser;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_report_id")
    private BanReport report;

    @Column(name = "ban_release_date")
    private LocalDateTime releaseDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public static long DEFAULT_BAN_PERIOD = 7L;

    public Ban(User banUser, BanReport report, LocalDateTime releaseDate) {
        this.banUser = banUser;
        this.report = report;
        this.releaseDate = releaseDate;
    }

    public void validateBanState(LocalDateTime now){
        if(releaseDate.isAfter(now)){
            throw new BannedUserException("해당 계정은 정지된 상태입니다");
        }
    }
}
