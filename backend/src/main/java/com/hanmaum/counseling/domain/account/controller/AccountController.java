package com.hanmaum.counseling.domain.account.controller;

import com.hanmaum.counseling.domain.account.dto.*;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * account에 대한 처리를 위한 컨트롤러
 * 작성자: 윤기현
 */

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final JwtProvider jwtProvider;

    @GetMapping("/admin/get")
    public String getAdmin(){
        return "관리자";
    }
    @GetMapping("/user/get")
    public String getUser(){
        return "일반 유저";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupDto request){
        accountService.saveUser(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @Valid LoginDto request){
        User user = accountService.findByEmailAndPassword(request);
        String token = jwtProvider.generateToken(user);
        JwtTokenDto response = JwtTokenDto.builder().token(token).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/email-check")
    public ResponseEntity<?> emailCheck(@RequestBody EmailCheckDto email){
        RedundancyDto result = accountService.existEmail(email.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/nickname-check")
    public ResponseEntity<?> nicknameCheck(@RequestBody NicknameCheckDto nickname){
        RedundancyDto result = accountService.existNickName(nickname.getNickname());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}