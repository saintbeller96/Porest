package com.hanmaum.counseling.domain.service.ban;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.ban.Ban;
import com.hanmaum.counseling.domain.model.ban.BanReport;

public interface BanService {
    public final static int DEFAULT_BAN_PERIOD = 7;
    Ban release(Long banId);
    Ban register(BanReport banReport);
    void validateUserBanState(User user);
}
