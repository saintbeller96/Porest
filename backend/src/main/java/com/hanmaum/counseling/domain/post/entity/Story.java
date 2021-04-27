package com.hanmaum.counseling.domain.post.entity;

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

    private Long from;

    private Long to;

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
}
