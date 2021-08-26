package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.ban.Ban;

import java.util.List;

public interface BanService {
    Ban release(Long banId);
    Ban register(Ban ban);
    void validateUserBanState(User user);
}
