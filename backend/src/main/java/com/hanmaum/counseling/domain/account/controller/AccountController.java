package com.hanmaum.counseling.domain.account.controller;

import com.google.api.Http;
import com.hanmaum.counseling.domain.account.dto.*;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.service.AccountService;
import exception.UserNotFoundException;
import exception.WrongPasswordException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * account에 대한 처리를 위한 컨트롤러
 * 작성자: 윤기현
 */

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupDto request){
        User user = accountService.saveUser(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @Valid LoginDto request) throws LoginException {
        JwtTokenDto result = accountService.findByEmailAndPassword(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/email-check")
    public ResponseEntity<RedundancyDto> emailCheck(@RequestBody @Valid EmailCheckDto email){
        RedundancyDto result = accountService.existEmail(email.getEmail());
        return ResponseEntity.ok(result);
    }
    @PostMapping("/verify-check")
    public ResponseEntity<?> verifyCheck(@RequestBody VerifyDto verifyDto){
        return accountService.verifyCheck(verifyDto.getEmail(), verifyDto.getCode());
    }

    @PostMapping("/email-verify")
    public ResponseEntity<?> verify(@RequestBody EmailCheckDto emailVerifyDto) throws MessagingException {
        accountService.sendVerifyEmail(emailVerifyDto.getEmail());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update-password")
    public ResponseEntity<?> updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto, HttpServletRequest httpServletRequest) throws WrongPasswordException, UserNotFoundException {
        accountService.updatePassword(httpServletRequest, updatePasswordDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("update-nickname")
    public ResponseEntity<?> updateNickname(@RequestBody UpdateNicknameDto updateNicknameDto, HttpServletRequest httpServletRequest){
        accountService.updateNickname(httpServletRequest, updateNicknameDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(HttpServletRequest request) throws UserNotFoundException {
        accountService.deleteUser(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/find-password")
    public ResponseEntity<?> findPassword(@RequestBody FindPasswordDto findPasswordDto) throws MessagingException {
        return accountService.findPassword(findPasswordDto.getEmail(), findPasswordDto.getNickname());
    }
}