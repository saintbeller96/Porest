package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.Password;
import com.hanmaum.counseling.domain.account.RoleType;
import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.ban.service.BanService;
import com.hanmaum.counseling.presentation.account.dto.*;
import com.hanmaum.counseling.security.JwtProvider;
import com.hanmaum.counseling.commons.EmailService;
import com.hanmaum.counseling.commons.RedisService;
import com.hanmaum.counseling.error.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final BanService banService;
    private final JwtProvider jwtProvider;
    private final EmailService emailService;
    private final RedisService redisService;

    public User saveUser(String email, String password, String nickname, String code){
        //이메일 중복 및 인증 여부 체크
        String key = createKey(email, code);
        String emailCheck = redisService.getData(key);
        if(emailCheck == null || !emailCheck.equals("T")){
            throw new IllegalArgumentException("이메일 중복 및 인증을 진행해주세요.");
        }
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .password(new Password(password, passwordEncoder))
                .temperature(36)
                .profileImgNumber(1L)
                .role(RoleType.ROLE_USER)
                .build();

        //캐싱된 데이터 삭제
        redisService.deleteData(email);
        redisService.deleteData(key);
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public JwtTokenDto login(String email, String password){
        User user = getUser(email);
        //해당 유저가 밴 상태인지 확인
        banService.validateUserBanState(user);
        user.login(password);
        return new JwtTokenDto(jwtProvider.generateToken(user));
    }

    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        User user = getUser(userId);
        user.updatePassword(newPassword);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public void updateNickname(Long userId, String newNickname) {
        User user = getUser(userId);
        user.setNickname(newNickname);
    }

    public boolean existEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String verifyCheck(String email, String code){
        String key = createKey(email, code);
        return redisService.verifyEmailByKey(key);
    }

    public void sendVerifyEmail(String email) {
        String code = RandomStringUtils.randomAlphabetic(5);
        String key = createKey(email, code);
        redisService.setDataExpire(key, "F", 180L);
        emailService.sendMail(email, "POREST 인증 메일 입니다." ,code);
    }

    private String createKey(String email, String code) {
        return String.format("%s_%s", email, code);
    }

    public void deleteUser(Long userId) {
        userRepository.delete(getUser(userId));
    }

    public void findPassword(String email, String nickname) {
        boolean isExist = userRepository.existsByEmailAndNickname(email, nickname);
        if (!isExist) {
            throw new UserNotFoundException();
        }
        //임시 비밀번호 메일 전송
        User user = getUser(email);
        String temporaryPassword = RandomStringUtils.randomAlphabetic(8);
        user.updatePassword(temporaryPassword);
        emailService.sendMail(email,"POREST의 임시 비밀번호 메일입니다.", temporaryPassword);
    }
}