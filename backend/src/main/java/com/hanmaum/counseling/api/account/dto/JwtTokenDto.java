package com.hanmaum.counseling.api.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JwtTokenDto {
    private String Token;

    public JwtTokenDto(String token) {
        Token = token;
    }
}
