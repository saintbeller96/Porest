package com.hanmaum.counseling.presentation.emotion.dto;

import com.hanmaum.counseling.domain.emotion.Emotion;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmotionSimpleDto {
    private Long emotionId;
    private int feeling;
    private int day;

    @Builder
    public EmotionSimpleDto(Long emotionId, int feeling, int day) {
        this.emotionId = emotionId;
        this.feeling = feeling;
        this.day = day;
    }

    public static EmotionSimpleDto of(Emotion emotion) {
        return EmotionSimpleDto.builder()
                .emotionId(emotion.getId())
                .feeling(emotion.getFeeling())
                .day(emotion.getDay())
                .build();
    }
}
