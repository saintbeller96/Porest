package com.hanmaum.counseling.domain.ban.entity;

import com.hanmaum.counseling.domain.account.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class BanReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_request_id")
    private Long id;

    @Column(name = "reporter_id")
    private Long reporterId;

    @Column(name = "ban_counsel_id", nullable = false)
    private Long counselId;

    @Column(name = "ban_reason")
    private String banReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "ban_report_status")
    private BanStatus banReportStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public BanReport(Long reporterId, Long counselId, String banReason, BanStatus banReportStatus, LocalDateTime createdAt) {
        this.reporterId = reporterId;
        this.counselId = counselId;
        this.banReason = banReason;
        this.banReportStatus = banReportStatus;
        this.createdAt = createdAt;
    }
}
