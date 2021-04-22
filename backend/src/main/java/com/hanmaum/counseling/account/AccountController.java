package com.hanmaum.counseling.account;

import com.hanmaum.counseling.account.Entity.User;
import com.hanmaum.counseling.account.request.LoginRequest;
import com.hanmaum.counseling.account.request.RegistrationRequest;
import com.hanmaum.counseling.account.service.AccountService;
import com.hanmaum.counseling.config.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegistrationRequest registrationRequest){
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setNickname(registrationRequest.getNickname());
        accountService.saveUser(user);
        return "OK";
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request){
        User user = accountService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new LoginResponse(token);
    }
}
