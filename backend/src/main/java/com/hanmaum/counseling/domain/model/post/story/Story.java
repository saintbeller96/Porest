package com.hanmaum.counseling.domain.model.post.story;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.post.Form;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.access.AccessDeniedException;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private User writer;

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

    @Builder
    public Story(User writer, String writerNickName,  String title, String content) {
        this.writer = writer;
        this.writerNickName = writerNickName;
        this.form = new Form(title, content);
    }

    public void addCounsel(Counsel counsel){
        this.counsels.add(counsel);
        counsel.setStory(this);
    }
    public void addPicked() {
        this.picked+=1;
    }

    public void validateUser(Long userId) {
        if (this.getWriter().getId() != userId) {
            throw new AccessDeniedException("현재 사용자는 이 사연에 접근할 수 없습니다.");
        }
    }

    public String getTitle() {
        return this.form.getTitle();
    }

    public String getContent() {
        return this.form.getContent();
    }
}
