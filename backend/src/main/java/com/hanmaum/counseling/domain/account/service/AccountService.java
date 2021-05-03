package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.dto.JwtTokenDto;
import com.hanmaum.counseling.domain.account.dto.RedundancyDto;
import com.hanmaum.counseling.domain.account.dto.SignupDto;
import com.hanmaum.counseling.domain.account.dto.LoginDto;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public User saveUser(@Valid SignupDto request){
        //이메일 또는 닉네임 중복 체크
        if(!existEmail(request.getEmail()).isRedundancy() || !existNickname(request.getNickname()).isRedundancy()) {
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

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(IllegalStateException::new);
    }

    public JwtTokenDto findByEmailAndPassword(LoginDto request){
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(IllegalStateException::new);
        String token = jwtProvider.generateToken(user);
        return JwtTokenDto.builder().token(token).build();
    }

    public RedundancyDto existNickname(String nickname) {
        boolean redundancy = userRepository.existsByNickname(nickname);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }

    public RedundancyDto existEmail(String email) {
        boolean redundancy = userRepository.existsByEmail(email);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }
}
