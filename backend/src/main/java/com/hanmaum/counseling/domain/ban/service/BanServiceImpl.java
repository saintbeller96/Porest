package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
