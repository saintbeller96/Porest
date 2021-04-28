package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long id;

    @Column(name = "is_opened")
    @ColumnDefault("false")
    private Boolean isOpened;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StoryStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Story(){};

    public static Story ofNew(){
        return Story.builder()
                .status(StoryStatus.READY)
                .build();
    }

    @Builder
    public Story(Boolean isOpened, StoryStatus status) {
        this.isOpened = isOpened;
        this.status = status;
    }
}
