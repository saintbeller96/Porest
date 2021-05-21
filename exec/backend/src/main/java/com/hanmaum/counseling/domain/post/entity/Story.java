package com.hanmaum.counseling.domain.post.entity;

import com.hanmaum.counseling.commons.NicknameGenerator;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "writer_nickname")
    private String writerNickName;

    @Column(name = "picked")
    @ColumnDefault("0")
    private int picked;

    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Counsel> counsels = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Story(){};

    public void addCounsel(Counsel counsel){
        this.counsels.add(counsel);
        counsel.setStory(this);
    }

    @Builder
    public Story(Long writerId, String title, String content) {
        this.writerId = writerId;
        this.writerNickName = NicknameGenerator.generateNegative();
        this.form = new Form(title, content);
    }

    public void addPicked() {
        this.picked+=1;
    }
}
