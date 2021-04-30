package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(name = "writer_id")
    private Long writerId;

    @Embedded
    private Form form;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "letter_id")
    private Letter letter;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Reply() {}

    @Builder
    public Reply(Long writerId, String title, String content, Letter letter) {
        this.writerId = writerId;
        this.form = new Form(title, content);
        this.letter = letter;
    }
}
