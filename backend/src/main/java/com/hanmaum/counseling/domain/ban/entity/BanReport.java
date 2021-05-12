package com.hanmaum.counseling.domain.ban.entity;

import com.hanmaum.counseling.domain.account.entity.User;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class BanReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_request_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User reporter;

    @Column(name = "ban_counsel_id", nullable = false)
    private Long counselId;

    @Column(name = "ban_reason")
    private String banReason;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
