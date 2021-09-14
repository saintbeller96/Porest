package com.hanmaum.counseling.security;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.user.UserRepository;
import com.hanmaum.counseling.error.UserNotFoundException;
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