package com.hanmaum.counseling.domain.post.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;

    @Column(name = "writer_id")
    private Long writerId;

    @Column(name = "content", columnDefinition="TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @OneToOne(mappedBy = "letter")
    private Reply reply;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
