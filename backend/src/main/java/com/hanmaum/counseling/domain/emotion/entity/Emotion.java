package com.hanmaum.counseling.domain.emotion.entity;

import com.hanmaum.counseling.domain.emotion.dto.EmotionDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Emotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emotion_id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "feeling")
    private Integer feeling;

    @Column(name = "content")
    private String content;

    @Column(name = "image_url")
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Builder
    public Emotion(Integer feeling, String content, String imageUrl, Long userId) {
        this.feeling = feeling;
        this.content = content;
        this.imageUrl = imageUrl;
        this.userId = userId;
    }

    public int getYear(){
        return createdAt.getYear();
    }
    public int getMonth(){
        return createdAt.getMonthValue();
    }
    public int getDay(){
        return createdAt.getDayOfMonth();
    }

    public void update(EmotionDetailDto dto){
        this.feeling = dto.getFeeling();
        this.content = dto.getContent();
        this.imageUrl = dto.getImageUrl();
    }

    public static Emotion convertedFromDto(EmotionDetailDto dto, Long userId){
        return Emotion.builder()
                .userId(userId)
                .content(dto.getContent())
                .feeling(dto.getFeeling())
                .imageUrl(dto.getImageUrl())
                .build();
    }
}
