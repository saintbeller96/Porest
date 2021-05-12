package com.hanmaum.counseling.domain.ban.entity;

import com.hanmaum.counseling.domain.account.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Ban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_request_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private BanReport report;

    private LocalDateTime untilDate;
}
