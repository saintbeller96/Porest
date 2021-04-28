package com.hanmaum.counseling.domain.post.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Link {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private Long id;
    @Column(name = "from_id", nullable = false, updatable = false)
    private Long fromId;
    @Column(name = "to_id", nullable = false, updatable = false)
    private Long toId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;
}
