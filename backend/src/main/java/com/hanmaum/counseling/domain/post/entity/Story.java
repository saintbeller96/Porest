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

    @Column(name = "writer_id", nullable = false)
    private Long writerId;

    @Embedded
    private Form form;

    @Column(name = "is_opened")
    @ColumnDefault("false")
    private Boolean isOpened;

    @Column(name = "picked")
    @ColumnDefault("0")
    private int picked;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Story(){};

    @Builder
    public Story(Long writerId, String title, String content, Boolean isOpened) {
        this.writerId = writerId;
        this.form = new Form(title, content);
        this.isOpened = isOpened;
    }

    public void addPicked() {
        this.picked+=1;
    }
}
