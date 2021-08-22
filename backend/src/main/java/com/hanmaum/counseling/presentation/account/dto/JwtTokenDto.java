package com.hanmaum.counseling.presentation.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JwtTokenDto {
    private String Token;

    @Builder
    public JwtTokenDto(String token) {
        Token = token;
    }
}
