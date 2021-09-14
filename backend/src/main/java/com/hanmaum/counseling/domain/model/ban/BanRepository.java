package com.hanmaum.counseling.domain.model.ban;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanRepository extends JpaRepository<Ban, Long>, BanRepositoryCustom {
}
