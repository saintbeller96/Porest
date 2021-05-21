package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class VerifyDto {
    @NotEmpty
    @Email
    @Size(max = 40)
    private String email;
    @NotEmpty
    @Size(min = 5, max = 5)
    private String code;

    @Builder
    public VerifyDto(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
