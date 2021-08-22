package com.hanmaum.counseling.presentation.post.dto;

import com.hanmaum.counseling.domain.post.letter.Letter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@ToString
public class LetterReplyDto {
    @NotNull
    private LetterDto letter;
    private LetterDto reply;

    @Builder
    public LetterReplyDto(Letter letter, Letter reply) {
        this.letter = LetterDto.of(letter);
        this.reply = LetterDto.of(reply);
    }

    public static LetterReplyDto of(Letter letter, Letter reply){
        return LetterReplyDto.builder()
                .letter(letter)
                .reply(reply)
                .build();
    }
}
