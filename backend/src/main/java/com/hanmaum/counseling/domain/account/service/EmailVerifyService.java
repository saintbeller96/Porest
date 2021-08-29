package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.commons.EmailService;
import com.hanmaum.counseling.commons.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailVerifyService {
    private final RedisService redisService;
    private final EmailService emailService;

    public void verifyEmail(String email, String code) {
        String key = createKey(email, code);
        String emailCheck = redisService.getData(key);
        if(emailCheck == null || !emailCheck.equals("T")){
            throw new IllegalArgumentException("이메일 중복 및 인증을 진행해주세요.");
        }
        //캐싱된 데이터 삭제
        redisService.deleteData(email);
        redisService.deleteData(key);
    }

    public String getVerifiedEmail(String email, String code){
        String key = createKey(email, code);
        return redisService.verifyEmailByKey(key);
    }

    public void sendVerifyEmail(String email) {
        String code = RandomStringUtils.randomAlphabetic(5);
        String key = createKey(email, code);
        emailService.sendMail(email, "POREST 인증 메일 입니다." ,code);
        redisService.setDataExpire(key, "F", 180L);
    }

    public String sendTemporaryPassword(String email) {
        String temporaryPassword = RandomStringUtils.randomAlphabetic(8);
        emailService.sendMail(email,"POREST의 임시 비밀번호 메일입니다.", temporaryPassword);
        return temporaryPassword;
    }

    private String createKey(String email, String code) {
        return String.format("%s_%s", email, code);
    }
}

