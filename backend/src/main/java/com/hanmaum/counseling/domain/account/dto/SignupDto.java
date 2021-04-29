package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * signup 요청일 때, request 정보가 담김
 * 작성자: 윤기현
 */
@Getter
@ToString
public class SignupDto {

    @NotEmpty //null,과 빈 문자열(스페이스 포함 불가) 불가
    @Size(min=8, max=20)
    private String password;

    @NotEmpty
    @Email
    @Size(max = 40)
    private String email;

    @NotEmpty
    @Size(max = 20)
    private String nickname;

    @Builder
    public SignupDto(@NotEmpty @Size(min = 8, max = 20) String password, @NotEmpty @Email @Size(max = 40) String email, @NotEmpty @Size(max = 20) String nickname) {
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }
}