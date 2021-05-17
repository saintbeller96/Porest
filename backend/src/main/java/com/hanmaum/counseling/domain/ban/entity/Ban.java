package com.hanmaum.counseling.domain.ban.entity;

import exception.BannedUserException;
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

    @Column(name = "ban_user_id")
    private Long banUserId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_report_id")
    private BanReport report;

    @Column(name = "ban_release_date")
    private LocalDateTime releaseDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ban_status")
    private BanStatus banStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public static long BAN_PERIOD = 7L;

    @Builder
    public Ban(Long banUserId, BanReport report, LocalDateTime releaseDate, BanStatus banStatus) {
        this.banUserId = banUserId;
        this.report = report;
        this.releaseDate = releaseDate;
        this.banStatus = banStatus;
    }

    public void validate(LocalDateTime now){
        if(releaseDate.isAfter(now)){
            throw new BannedUserException("해당 계정은 정지된 상태입니다");
        }
    }
    public void releaseBan(){
        this.banStatus = BanStatus.RELEASED;
    }

}
