package com.hanmaum.counseling.presentation.emotion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmotionSimpleDto {
    private Long emotionId;
    private int feeling;
    private int day;

    public EmotionSimpleDto(Long emotionId, int feeling, int day) {
        this.emotionId = emotionId;
        this.feeling = feeling;
        this.day = day;
    }
}
