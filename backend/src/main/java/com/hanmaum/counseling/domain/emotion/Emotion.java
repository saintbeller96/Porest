package com.hanmaum.counseling.domain.emotion;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionDetailDto;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
    public Emotion(Integer feeling, String content, String imageUrl, User user) {
        this.feeling = feeling;
        this.content = content;
        this.imageUrl = imageUrl;
        this.user = user;
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

    public void update(Integer feeling, String content, String imageUrl){
        this.feeling = feeling;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
