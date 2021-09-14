package com.hanmaum.counseling.api.account;

import com.hanmaum.counseling.commons.EmailPasswordFindService;
import com.hanmaum.counseling.commons.VerifyService;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.api.account.dto.*;
import com.hanmaum.counseling.api.argumentresolver.LoginUserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * account에 대한 처리를 위한 컨트롤러
 * 작성자: 윤기현
 * 수정: 김종성
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final VerifyService verifyService;
    private final EmailPasswordFindService passwordFindService;

    @PostMapping("")
    public ResponseEntity<?> signup(@RequestBody @Valid SignupDto request){
        verifyService.verify(request.getEmail(), request.getCode());
        accountService.registerUser(request.getEmail(), request.getPassword(), request.getNickname());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtTokenDto> login(@RequestBody @Valid LoginDto loginDto) {
        return ResponseEntity.ok(new JwtTokenDto(accountService.login(loginDto.getEmail(), loginDto.getPassword())));
    }

    @PostMapping("/email-check")
    public ResponseEntity<RedundancyDto> emailCheck(@RequestBody @Valid EmailCheckDto email){
        return ResponseEntity.ok(RedundancyDto.of(accountService.existEmail(email.getEmail())));
    }

    @PostMapping("/send-verify")
    public ResponseEntity<?> verify(@RequestBody @Valid EmailCheckDto emailVerifyDto) {
        verifyService.sendVerifyMessage(emailVerifyDto.getEmail());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<?> updatePassword(@RequestBody @Valid UpdatePasswordDto updatePasswordDto,
                                            @PathVariable Long id,
                                            @LoginUserId Long userId){
        accountService.updatePassword(userId, updatePasswordDto.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/nickname")
    public ResponseEntity<?> updateNickname(@RequestBody @Valid UpdateNicknameDto updateNicknameDto,
                                            @PathVariable Long id,
                                            @LoginUserId Long userId){
        accountService.updateNickname(userId, updateNicknameDto.getNickname());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteUser(@LoginUserId Long userId) {
        accountService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/find-password")
    public ResponseEntity<?> findPassword(@RequestBody @Valid FindPasswordDto findPasswordDto) {
        String temp = passwordFindService.sendTemporaryPassword(findPasswordDto.getEmail());
        accountService.updatePassword(findPasswordDto.getEmail(), temp);
        return ResponseEntity.ok().build();
    }
}