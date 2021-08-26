package com.hanmaum.counseling.domain.post.counsel;

import com.hanmaum.counseling.commons.NicknameGenerator;
import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.post.letter.Letter;
import com.hanmaum.counseling.domain.post.story.Story;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="counsellor_id")
    private User counsellor;

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
    public Counsel(Story story, User counsellor, CounselStatus status) {
        this.story = story;
        this.counsellor = counsellor;
//        this.counsellorNickname = NicknameGenerator.generatePositive();
//        this.counsellorId = counsellorId;
        this.status = status;
    }

    public void addLetter(Letter letter){
        this.letters.add(letter);
        letter.setCounsel(this);
    }

    public void setStory(Story story){
        this.story = story;
    }
    public void setStatus(CounselStatus status){
        this.status = status;
    }
    public void setOpenStatus(boolean b) {this.isOpened = b;}
}
