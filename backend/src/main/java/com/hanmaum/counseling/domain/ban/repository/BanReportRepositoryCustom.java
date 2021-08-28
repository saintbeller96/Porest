package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.BanReport;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportRepositoryCustom {
    Page<BanReport> findWaitingReport(Pageable pageable);
}
