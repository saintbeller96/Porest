package com.hanmaum.counseling.domain.service.user;

import com.hanmaum.counseling.domain.model.user.Password;
import com.hanmaum.counseling.domain.model.user.RoleType;
import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.user.UserRepository;
import com.hanmaum.counseling.domain.service.ban.BanService;
import com.hanmaum.counseling.security.JwtProvider;
import com.hanmaum.counseling.error.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AccountService {

    private final UserRepository userRepository;
    private final BanService banService;
    private final JwtProvider jwtProvider;

    public User registerUser(String email, String password, String nickname){
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

    public String login(String email, String password){
        User user = getUser(email);
        //해당 유저가 밴 상태인지 확인
        banService.validateUserBanState(user);
        user.login(password);
        return jwtProvider.generateToken(user);
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