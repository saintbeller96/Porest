package com.hanmaum.counseling.domain.model.ban;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
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
public class BanReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ban_report_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporter_id", nullable = false)
    private User reporter;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ban_counsel_id", nullable = false)
    private Counsel counsel;

    @Column(name = "ban_reason")
    private String banReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "ban_report_status")
    private BanReportStatus banReportStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public BanReport(Long id, User reporter, Counsel counsel, String banReason, BanReportStatus banReportStatus) {
        this.id = id;
        this.reporter = reporter;
        this.counsel = counsel;
        this.banReason = banReason;
        this.banReportStatus = banReportStatus;
    }

    public User getCounsellorUser() {
        return counsel.getCounsellor();
    }

    public void process(){
        this.banReportStatus = BanReportStatus.PROCESSED;
    }

    public void cancel(){
        this.banReportStatus = BanReportStatus.CANCEL;
    }
}
