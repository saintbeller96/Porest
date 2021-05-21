package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindPasswordDto {
    private String email;
    private String nickname;

    @Builder
    public FindPasswordDto(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}