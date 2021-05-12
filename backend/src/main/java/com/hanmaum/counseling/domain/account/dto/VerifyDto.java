package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VerifyDto {
    private String email;
    private String code;

    @Builder
    public VerifyDto(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
