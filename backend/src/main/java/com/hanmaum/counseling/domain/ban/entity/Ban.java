package com.hanmaum.counseling.domain.ban.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private void validate(LocalDateTime now){
        if(releaseDate.isAfter(now)){
            throw new IllegalStateException("해당 계정은 정지된 상태입니다");
        }
    }
    private void releaseBan(){
        this.banStatus = BanStatus.RELEASE;
    }
}
