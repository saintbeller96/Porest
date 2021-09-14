package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.api.account.dto.SignupDto;
import com.hanmaum.counseling.security.JwtProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class AccountServiceTest {
    static final String LOGIN_FAIL = "아이디 비밀번호 확인";
    static final String NOT_FOUND = "없는 유저";
    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    String email = "test@test.com";
    String password = "testtest";

    @Test
    void saveUser() {
    }

    @Test
    void findByEmailAndPassword() {

    }

    @Test
    void updatePassword() {
    }

    @Test
    void existEmail() {
    }

    @Test
    void deleteUser() {
    }

    private SignupDto createUser(String email, String password){
        return SignupDto.builder()
                .email(email)
                .password(password)
                .build();
    }
}