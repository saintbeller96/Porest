package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "to_id")
    private Long toId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @OneToMany(mappedBy = "post")
    private List<Letter> letters = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @ColumnDefault("'CONNECT'")
    private PostStatus status;

    public Posts(){}

    @Builder
    public Posts(Story story, Long toId, PostStatus status) {
        this.story = story;
        this.toId = toId;
        this.status = status;
    }
}
