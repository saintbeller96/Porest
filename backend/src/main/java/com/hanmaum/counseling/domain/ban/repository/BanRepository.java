package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.Ban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban, Long>, BanRepositoryCustom {
}
