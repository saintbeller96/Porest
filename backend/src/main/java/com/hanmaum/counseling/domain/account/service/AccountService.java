package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.dto.*;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.security.JwtProvider;
import exception.UserNotFoundException;
import exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AccountService {
    static final String LOGIN_FAIL = "아이디 비밀번호 확인";
    static final String NOT_FOUND = "없는 유저";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public User saveUser(@Valid SignupDto request){
        //이메일 중복 체크
        if(!existEmail(request.getEmail()).isRedundancy()) {
            throw new IllegalStateException();
        }

        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(RoleType.ROLE_USER)
                .build();

        return userRepository.save(user);
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException(NOT_FOUND));
    }

    public JwtTokenDto findByEmailAndPassword(LoginDto request) throws LoginException {
      User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new LoginException(LOGIN_FAIL));
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new LoginException(LOGIN_FAIL);
        }
        String token = jwtProvider.generateToken(user);
        return JwtTokenDto.builder().token(token).build();
    }

    public void updatePassword(HttpServletRequest request, UpdatePasswordDto updatePasswordDto) throws WrongPasswordException, UserNotFoundException {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);
        User user = findByEmail(email);
        if (!passwordEncoder.matches(updatePasswordDto.getOldPassword(), user.getPassword())) {
             throw new WrongPasswordException("비밀번호가 틀렸습니다.");
        }
        String newPassword = passwordEncoder.encode(updatePasswordDto.getNewPassword());
        user.setPassword(newPassword);
        userRepository.save(user);
    }


    public RedundancyDto existEmail(String email) {
        boolean redundancy = userRepository.existsByEmail(email);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }


    public void deleteUser(HttpServletRequest request) throws UserNotFoundException {
        String token = request.getHeader("Authorization").substring(7);
        String email = jwtProvider.getEmailFromToken(token);
        User user = findByEmail(email);
        userRepository.delete(user);
    }
}