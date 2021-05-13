package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportService {
    Long reportBan(Long userId);
    Page<BanReportDetailDto> getBanReports(Pageable pageable);
}
