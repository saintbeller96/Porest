package com.hanmaum.counseling.presentation.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class FindPasswordDto {
    @Email
    private String email;
    @NotEmpty
    private String nickname;

    @Builder
    public FindPasswordDto(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}