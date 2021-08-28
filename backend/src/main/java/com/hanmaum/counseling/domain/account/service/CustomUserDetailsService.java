package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.error.UserNotFoundException;
import com.hanmaum.counseling.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(UserNotFoundException::new);
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}