package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateNicknameDto {

    private String nickname;

    @Builder
    public UpdateNicknameDto(String nickname) {
        this.nickname = nickname;
    }
}
