package com.hanmaum.counseling.domain.account.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationRequest {
    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    //TODO: 랜덤으로 부여를 할 것인가? 논의 해봐야 함
    private String nickname;
}
