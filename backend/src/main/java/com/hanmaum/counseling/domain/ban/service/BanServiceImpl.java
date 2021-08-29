package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.BanReport;
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
    public final static int DEFAULT_BAN_PERIOD = 7;
    private final BanRepository banRepository;

    @Override
    public Ban release(Long banId) {
        Ban ban = banRepository.findById(banId)
                .orElseThrow();
        banRepository.delete(ban);
        return ban;
    }

    @Override
    public Ban register(BanReport banReport) {
        Ban ban = new Ban(banReport.getCounsellorUser(), banReport, LocalDateTime.now().plusDays(DEFAULT_BAN_PERIOD));
        return banRepository.save(ban);
    }

    @Override
    public void validateUserBanState(User user) {
        List<Ban> banList = banRepository.findByUserId(user.getId());
        for (Ban ban : banList) {
            ban.validateBanExpired(LocalDateTime.now());
            banRepository.delete(ban);
        }
    }
}
