package com.hanmaum.counseling.domain.ban.entity;

import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.ban.dto.BanReportDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class BanReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_report_id")
    private Long id;

    @Column(name = "reporter_id")
    private Long reporterId;

    @Column(name = "ban_counsel_id", nullable = false)
    private Long counselId;

    @Column(name = "ban_reason")
    private String banReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "ban_report_status")
    private BanReportStatus banReportStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Builder
    public BanReport(Long reporterId, Long counselId, String banReason, BanReportStatus banReportStatus) {
        this.reporterId = reporterId;
        this.counselId = counselId;
        this.banReason = banReason;
        this.banReportStatus = banReportStatus;
    }

    public static BanReport of(BanReportDto dto, Long reporterId){
        return BanReport.builder()
                .reporterId(reporterId)
                .counselId(dto.getCounselId())
                .banReason(dto.getBanReason())
                .banReportStatus(BanReportStatus.PROCEEDING)
                .build();
    }

    public void process(){
        this.banReportStatus = BanReportStatus.PROCESSED;
    }

    public void cancel(){
        this.banReportStatus = BanReportStatus.CANCEL;
    }
}
