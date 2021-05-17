package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportRepositoryCustom {
    Page<BanReportDetailDto> findProceedingReport(Pageable pageable);
}
