package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.dto.RedundancyDto;
import com.hanmaum.counseling.domain.account.dto.SignupDto;
import com.hanmaum.counseling.domain.account.dto.LoginDto;
import com.hanmaum.counseling.domain.account.entity.Role;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.RoleRepository;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(@Valid SignupDto request){
        Role userRole = roleRepository.findByName("ROLE_USER");

        User user = User.builder()
                .email(request.getEmail())
                .nickname(request.getNickname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(userRole)
                .build();

        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User findByEmailAndPassword(LoginDto request){
        User user = findByEmail(request.getEmail());
        if(user != null){
            if(passwordEncoder.matches(request.getPassword(), user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public RedundancyDto existNickName(String nickname) {
        boolean redundancy = userRepository.existsByNickname(nickname);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }

    public RedundancyDto existEmail(String email) {
        boolean redundancy = userRepository.existsByEmail(email);
        return RedundancyDto.builder().redundancy(!redundancy).build();
    }
}
