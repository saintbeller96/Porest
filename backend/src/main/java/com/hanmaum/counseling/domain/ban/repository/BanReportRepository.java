package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.BanReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanReportRepository extends JpaRepository<BanReport, Long>, BanReportRepositoryCustom {
}
