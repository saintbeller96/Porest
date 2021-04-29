package com.hanmaum.counseling.domain.account.service;

import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.security.CustomUserDetails;
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
        System.out.print(user.toString());
        return CustomUserDetails.fromUserToCustomUserDetails(user);
    }
}
