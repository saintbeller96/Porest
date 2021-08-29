package com.hanmaum.counseling.presentation.account;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.account.service.EmailVerifyService;
import com.hanmaum.counseling.presentation.account.dto.*;
import com.hanmaum.counseling.error.UserNotFoundException;
import com.hanmaum.counseling.error.WrongPasswordException;
import com.hanmaum.counseling.presentation.argumentresolver.LoginUserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final EmailVerifyService emailVerifyService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupDto request){
        emailVerifyService.verifyEmail(request.getEmail(), request.getCode());
        accountService.saveUser(request.getEmail(), request.getPassword(), request.getNickname());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @Valid LoginDto loginDto) {
        JwtTokenDto result = accountService.login(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/email-check")
    public ResponseEntity<RedundancyDto> emailCheck(@RequestBody @Valid EmailCheckDto email){
        return ResponseEntity.ok(RedundancyDto.of(accountService.existEmail(email.getEmail())));
    }
    @PostMapping("/verify-check")
    public ResponseEntity<?> verifyCheck(@RequestBody VerifyDto verifyDto){
        String message = emailVerifyService.getVerifiedEmail(verifyDto.getEmail(), verifyDto.getCode());
        return ResponseEntity.ok(new VerifyRes(message, true));
    }

    @PostMapping("/email-verify")
    public ResponseEntity<?> verify(@RequestBody EmailCheckDto emailVerifyDto) {
        emailVerifyService.sendVerifyEmail(emailVerifyDto.getEmail());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto, @LoginUserId Long userId){
        accountService.updatePassword(userId, updatePasswordDto.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-nickname")
    public ResponseEntity<?> updateNickname(@RequestBody UpdateNicknameDto updateNicknameDto, @LoginUserId Long userId){
        accountService.updateNickname(userId, updateNicknameDto.getNickname());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@LoginUserId Long userId) {
        accountService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/find-password")
    public ResponseEntity<?> findPassword(@RequestBody FindPasswordDto findPasswordDto) {
        String temp = emailVerifyService.sendTemporaryPassword(findPasswordDto.getEmail());
        accountService.updatePassword(findPasswordDto.getEmail(), temp);
        return ResponseEntity.ok().build();
    }
}