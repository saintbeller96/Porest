package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.BanReport;

public interface BanService {
    public final static int DEFAULT_BAN_PERIOD = 7;
    Ban release(Long banId);
    Ban register(BanReport banReport);
    void validateUserBanState(User user);
}
