package com.hanmaum.counseling.domain.model.ban;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanReportRepository extends JpaRepository<BanReport, Long>, BanReportRepositoryCustom {
}
