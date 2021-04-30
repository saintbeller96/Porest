package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Counsel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "counsel_id")
    private Long id;

    @Column(name = "counsellor_id")
    private Long counsellorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @OneToMany(mappedBy = "post")
    private List<Letter> letters = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @ColumnDefault("'CONNECT'")
    private CounselStatus status;

    public Counsel(){}

    @Builder
    public Counsel(Story story, Long counsellorId, CounselStatus status) {
        this.story = story;
        this.counsellorId = counsellorId;
        this.status = status;
    }
}
