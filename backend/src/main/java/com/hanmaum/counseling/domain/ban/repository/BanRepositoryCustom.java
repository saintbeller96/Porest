package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.entity.Ban;

import java.util.List;
import java.util.Optional;

public interface BanRepositoryCustom {
    Optional<Ban> findByIdFetch(Long banId);
    List<Ban> findByUserIdFetch(Long userId);
    Boolean existsBannedUser(Long userId);
}
