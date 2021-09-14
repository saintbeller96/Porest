package com.hanmaum.counseling.domain.model.ban;

import com.hanmaum.counseling.domain.model.ban.BanReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BanReportRepositoryCustom {
    Page<BanReport> findWaitingReport(Pageable pageable);
}
