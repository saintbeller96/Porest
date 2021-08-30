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
    private final BanService banService;
    private final JwtProvider jwtProvider;

    public User saveUser(String email, String password, String nickname){
        User user = User.builder()
                .email(email)
                .nickname(nickname)
                .password(new Password(password))
                .temperature(36)
                .profileImgNumber(1L)
                .role(RoleType.ROLE_USER)
                .build();
        return userRepository.save(user);
    }

    public JwtTokenDto login(String email, String password){
        User user = getUser(email);
        //해당 유저가 밴 상태인지 확인
        banService.validateUserBanState(user);
        user.login(password);
        return new JwtTokenDto(jwtProvider.generateToken(user));
    }

    public void updatePassword(Long userId, String newPassword) {
        User user = getUser(userId);
        user.updatePassword(newPassword);
    }

    public void updatePassword(String email, String newPassword) {
        User user = getUser(email);
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

    public void deleteUser(Long userId) {
        userRepository.delete(getUser(userId));
    }
}