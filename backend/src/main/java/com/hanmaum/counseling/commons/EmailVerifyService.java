package com.hanmaum.counseling.commons;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailVerifyService implements VerifyService<String, String>{
    private static final Duration EXPIRED = Duration.ofSeconds(180L);
    private static final String FAIL_MESSAGE = "이메일 인증에 실패하였습니다.";
    private final RedisService redisService;
    private final EmailService emailService;

    @Override
    public void verify(String key, String value) {
        String expectValue = redisService.getData(key);
        if(!value.equals(expectValue)){
            log.debug("[verify fail] email: {} value: {}", key, value);
            throw new IllegalStateException(FAIL_MESSAGE);
        }
        //캐싱된 데이터 삭제
        redisService.deleteData(key);
    }

    @Override
    public void sendVerifyMessage(Object receiver) {
        String email = receiver.toString();
        String code = RandomStringUtils.randomAlphabetic(5);
        emailService.sendMail(email, "POREST 인증 메일 입니다.", code);
        redisService.setDataExpire(email, code, EXPIRED);
    }
}
