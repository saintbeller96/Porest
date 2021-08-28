package com.hanmaum.counseling.domain.post.letter;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.post.Form;
import com.hanmaum.counseling.domain.post.counsel.Counsel;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "letter_id")
    private Letter prevLetter;

    @Embedded
    private Form form;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private LetterStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counsel_id")
    private Counsel counsel;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Letter(){}
    @Builder
    public Letter(User writer, Letter prevLetter, String title, String content, LetterStatus status) {
        this.writer = writer;
        this.prevLetter = prevLetter;
        this.form = new Form(title, content);
        this.status = status;
    }

    public void setStatus(LetterStatus status){this.status = status;}
    public String getTitle(){
        return this.form.getTitle();
    }
    public String getContent(){
        return this.form.getContent();
    }

    public void setCounsel(Counsel counsel) {
        this.counsel = counsel;
    }

    public void read(Long readerId) {
        if(readerId == this.getCounsel().getCounsellor().getId()){
            this.setStatus(LetterStatus.READ);
        }
    }
}
