package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.BanReport;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportService {
    BanReport report(Long counselId, String reason, Long reporterId);
    Ban process(Long banReportId);
    Long cancel(Long banReportId);
    Page<BanReport> getWaitingBanReports(Pageable pageable);
}
