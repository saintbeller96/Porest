package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdatePasswordDto {

    @NotEmpty
    @Size(min=8, max=20)
    private String oldPassword;

    @NotEmpty
    @Size(min=8, max=20)
    private String newPassword;

    @Builder
    public UpdatePasswordDto(@NotEmpty @Size(min = 8, max = 20) String oldPassword, @NotEmpty @Size(min = 8, max = 20) String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
