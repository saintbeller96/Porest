package com.hanmaum.counseling.account.service;

import com.hanmaum.counseling.account.Entity.User;
import com.hanmaum.counseling.config.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AccountService accountService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = accountService.findByEmail(username);
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}
