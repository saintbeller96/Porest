package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.Ban;

import java.util.List;
import java.util.Optional;

public interface BanRepositoryCustom {
    List<Ban> findByUserId(Long userId);
}
