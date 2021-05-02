package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class NicknameCheckDto {
    @NotEmpty
    @Size(max = 20)
    private String nickname;

    @Builder
    public NicknameCheckDto(@NotEmpty @Size(max = 20) String nickname) {
        this.nickname = nickname;
    }
}
