package com.hanmaum.counseling.commons;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailPasswordFindService {
    private final EmailService emailService;

    public String sendTemporaryPassword(String email) {
        String temporaryPassword = RandomStringUtils.randomAlphabetic(8);
        emailService.sendMail(email,"POREST의 임시 비밀번호 메일입니다.", temporaryPassword);
        return temporaryPassword;
    }
}
