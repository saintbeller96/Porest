package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class EmailCheckDto {
    @NotEmpty
    @Email
    @Size(max = 40)
    private String email;

    @Builder

    public EmailCheckDto(@NotEmpty @Email @Size(max = 40) String email) {
        this.email = email;
    }
}
