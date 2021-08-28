package com.hanmaum.counseling.presentation.emotion.dto;

import com.hanmaum.counseling.domain.emotion.Emotion;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class EmotionDetailDto {
    @PositiveOrZero
    private int feeling;
    @NotNull
    private String content;
    @NotNull
    private String imageUrl;
    private LocalDateTime createdAt;

    @Builder
    private EmotionDetailDto(@PositiveOrZero int feeling, @NotNull String content, @NotNull String imageUrl, LocalDateTime createdAt) {
        this.feeling = feeling;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }

    public static EmotionDetailDto of(Emotion entity){
        return EmotionDetailDto.builder()
                .content(entity.getContent())
                .feeling(entity.getFeeling())
                .createdAt(entity.getCreatedAt())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
