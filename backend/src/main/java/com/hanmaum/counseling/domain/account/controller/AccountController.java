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
        User user = accountService.saveUser(request);
        if(user != null)  return ResponseEntity.status(HttpStatus.OK).build();
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @Valid LoginDto request){
        JwtTokenDto result = accountService.findByEmailAndPassword(request);
        if(result != null) return ResponseEntity.ok(result);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/email-check")
    public ResponseEntity<RedundancyDto> emailCheck(@RequestBody @Valid EmailCheckDto email){
        RedundancyDto result = accountService.existEmail(email.getEmail());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/nickname-check")
    public ResponseEntity<RedundancyDto> nicknameCheck(@RequestBody @Valid NicknameCheckDto nickname){
        RedundancyDto result = accountService.existNickName(nickname.getNickname());
        return ResponseEntity.ok(result);
    }
}