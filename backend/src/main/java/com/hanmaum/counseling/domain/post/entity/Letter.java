package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
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

    @Embedded
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counsel_id")
    private Counsel counsel;

    @OneToOne(mappedBy = "letter")
    private Reply reply;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Letter(){}

    @Builder
    public Letter(Long writerId, String title, String content, Counsel counsel) {
        this.writerId = writerId;
        this.form = new Form(title, content);
        this.counsel = counsel;
    }
    public static Letter write(Long writerId, String title, String content, Counsel counsel){
        return Letter.builder()
                .writerId(writerId)
                .title(title)
                .content(content)
                .counsel(counsel)
                .build();
    }
}
