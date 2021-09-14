package com.hanmaum.counseling.api.post.dto;

import com.hanmaum.counseling.domain.model.post.letter.Letter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class LetterDto {
    private Long letterId;
    private FormDto detail;

    @Builder
    public LetterDto(Long letterId, String title, String content, LocalDateTime date) {
        this.letterId = letterId;
        this.detail = new FormDto(title, content, date);
    }

    public static LetterDto of(Letter letter) {
        if(letter == null) return null;
        return LetterDto.builder()
                .letterId(letter.getId())
                .title(letter.getTitle())
                .content(letter.getContent())
                .date(letter.getCreatedAt()).build();
    }
}
