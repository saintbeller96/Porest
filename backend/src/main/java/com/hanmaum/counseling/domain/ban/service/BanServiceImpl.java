package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BanServiceImpl implements BanService{

    private final BanRepository banRepository;

    @Override
    public Ban release(Long banId) {
        Ban ban = banRepository.findById(banId).orElseThrow();
        banRepository.delete(ban);
        return ban;
    }

    @Override
    public Ban register(Ban ban) {
        return banRepository.save(ban);
    }

    @Override
    public void validateUserBanState(User user) {
        List<Ban> banList = banRepository.findByUserId(user.getId());
        for (Ban ban : banList) {
            ban.validateBanState(LocalDateTime.now());
            release(ban.getId());
        }
    }
}
