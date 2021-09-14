package com.hanmaum.counseling.domain.service.ban;

import com.hanmaum.counseling.domain.model.ban.Ban;
import com.hanmaum.counseling.domain.model.ban.BanReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportService {
    BanReport report(Long counselId, String reason, Long reporterId);
    Ban process(Long banReportId);
    Long cancel(Long banReportId);
    Page<BanReport> getWaitingBanReports(Pageable pageable);
}
