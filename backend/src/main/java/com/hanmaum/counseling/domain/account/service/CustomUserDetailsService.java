package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private static final String NOT_FOUND = "사용자 없음";
    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(NOT_FOUND));
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}