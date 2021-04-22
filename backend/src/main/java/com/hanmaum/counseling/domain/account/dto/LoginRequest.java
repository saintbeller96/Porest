package com.hanmaum.counseling.domain.account.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    private String password;
}
