package com.hanmaum.counseling.domain.model.post.counsel;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.post.letter.Letter;
import com.hanmaum.counseling.domain.model.post.story.Story;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.access.AccessDeniedException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public Counsel(Long id, Story story, User counsellor, String counsellorNickname, CounselStatus status) {
        this.id = id;
        this.story = story;
        this.counsellor = counsellor;
        this.counsellorNickname = counsellorNickname;
        this.status = status;
    }

    public void addLetter(Letter letter){
        this.letters.add(letter);
        letter.setCounsel(this);
    }

    public void validateUser(Long userId) {
        if(!Objects.equals(counsellor.getId(), userId) && !Objects.equals(story.getWriter().getId(), userId)){
            throw new AccessDeniedException("현재 사용자는 이 상담 내역에 접근할 수 없습니다.");
        }
    }

    public void finish(int score, boolean open) {
        this.status = CounselStatus.END;
        this.isOpened = open;
        this.counsellor.updateTemperature(score);
    }

    public void setStory(Story story){
        this.story = story;
    }
    public void setStatus(CounselStatus status){
        this.status = status;
    }
    public void setOpenStatus(boolean b) {this.isOpened = b;}
}
