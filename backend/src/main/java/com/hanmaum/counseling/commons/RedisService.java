package com.hanmaum.counseling.commons;

import com.hanmaum.counseling.error.VerifyEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final String VERIFY_SUCCESS = "이메일 인증을 성공하였습니다.";
    private final String VERIFY_SUCCESS_ALREADY = "이미 이메일을 인증하였습니다.";
    private final StringRedisTemplate stringRedisTemplate;

    public String getData(String key){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void setData(String key, String value){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public void setDataExpire(String key,String value,long duration){
        ValueOperations<String,String> valueOperations = stringRedisTemplate.opsForValue();
        Duration expireDuration = Duration.ofSeconds(duration);
        valueOperations.set(key,value,expireDuration);
    }

    public void deleteData(String key){
        stringRedisTemplate.delete(key);
    }

    public String verifyEmailByKey(String key) {
        String verify = getData(key);
        if (Objects.isNull(verify)) {
            throw new VerifyEmailException();
        } else if ("F".equals(verify)) {
            setDataExpire(key, "T", 3600);
            return VERIFY_SUCCESS;
        }
        return VERIFY_SUCCESS_ALREADY;
    }
}