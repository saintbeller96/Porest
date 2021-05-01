package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Login request, response 처리를 함
 * 작성자: 윤기현
 */
@Getter
@NoArgsConstructor
public class LoginDto {
    @NotEmpty
    @Email
    @Size(max = 40)
    private String email;

    @NotEmpty
    @Size(min=8, max=20)
    private String password;

    @Builder
    public LoginDto(@NotEmpty @Email @Size(max = 40) String email) {
        this.email = email;
    }
}
