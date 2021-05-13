package com.hanmaum.counseling.domain.post.entity;

import com.hanmaum.counseling.commons.NicknameGenerator;
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

    @Column(name = "counsellor_nickname")
    private String counsellorNickname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "story_id")
    private Story story;

    @OneToMany(mappedBy = "counsel",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Letter> letters = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @ColumnDefault("'CONNECT'")
    private CounselStatus status;

    @Column(name = "is_opened")
    @ColumnDefault("false")
    private Boolean isOpened;

    public Counsel(){}

    @Builder
    public Counsel(Story story, Long counsellorId, CounselStatus status) {
        this.story = story;
        this.counsellorNickname = NicknameGenerator.generatePositive();
        this.counsellorId = counsellorId;
        this.status = status;
    }

    public void addLetter(Letter letter){
        this.letters.add(letter);
        letter.setCounsel(this);
    }

    public void setStory(Story story){
        this.story = story;
    }

    public static Counsel createConnectedCounsel(Story story, Long userId){
        return Counsel.builder()
                .story(story)
                .counsellorId(userId)
                .status(CounselStatus.CONNECT)
                .build();
    }

    public void setStatus(CounselStatus status){
        this.status = status;
    }
    public void setOpenStatus(boolean b) {this.isOpened = b;}
}
