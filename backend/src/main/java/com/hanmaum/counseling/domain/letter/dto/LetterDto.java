package com.hanmaum.counseling.domain.letter.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class LetterDto {
    @NotNull
    private Long writerId;

    @NotBlank
    private String content;

}
