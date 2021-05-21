package com.hanmaum.counseling.domain.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
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

    @Column(name = "writer_id")
    private Long writerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "letter_id")
    private Letter parentLetter;

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

    public void setCounsel(Counsel counsel){
        this.counsel = counsel;
    }
    public void setStatus(LetterStatus status){this.status = status;}

    public Letter(){}

    public String getTitle(){
        return this.form.getTitle();
    }
    public String getContent(){
        return this.form.getContent();
    }

    @Builder
    public Letter(Long writerId, Letter parentLetter, String title, String content, LetterStatus status) {
        this.writerId = writerId;
        this.parentLetter = parentLetter;
        this.form = new Form(title, content);
        this.status = status;
    }
    public static Letter write(Long writerId, Letter parentLetter, String title, String content){
        return Letter.builder()
                .writerId(writerId)
                .parentLetter(parentLetter)
                .title(title)
                .content(content)
                .status(LetterStatus.WAIT)
                .build();
    }

    @Override
    public String toString() {
        return String.format("%s  |  %s", this.form.getTitle(), this.form.getContent());
    }
}
