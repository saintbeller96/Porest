package com.hanmaum.counseling.domain.model.ban;

import com.hanmaum.counseling.domain.model.ban.Ban;

import java.util.List;

public interface BanRepositoryCustom {
    List<Ban> findByUserId(Long userId);
}
