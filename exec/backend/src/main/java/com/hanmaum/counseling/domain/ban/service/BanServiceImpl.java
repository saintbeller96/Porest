package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.ban.entity.Ban;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BanServiceImpl implements BanService{

    private final BanRepository banRepository;

    @Override
    public Long releaseBan(Long banId) {
        Ban ban = banRepository.findByIdFetch(banId).orElseThrow();
        ban.releaseBan();
        return ban.getId();
    }
}
