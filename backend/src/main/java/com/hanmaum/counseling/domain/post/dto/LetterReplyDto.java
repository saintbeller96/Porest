package com.hanmaum.counseling.domain.post.dto;

import com.hanmaum.counseling.domain.post.entity.Letter;
import com.hanmaum.counseling.domain.post.repository.story.CounselContent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
