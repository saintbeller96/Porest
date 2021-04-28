package com.hanmaum.counseling.domain.post.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class LetterReplyDto {
    @NotNull
    private FormDto letter;
    private FormDto reply;

    public LetterReplyDto(){};

    public LetterReplyDto(String letterTitle, String letterContent, LocalDateTime letterDate,
                          String replyTitle, String replyContent, LocalDateTime replyDate){
        this.letter = new FormDto(letterTitle, letterContent, letterDate);
        this.reply = new FormDto(replyTitle, replyContent, replyDate);
    }
}
