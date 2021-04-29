package com.hanmaum.counseling.domain.post.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Getter @Setter
public class Form {
    @Column(name = "title")
    @NotBlank
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    @NotBlank
    private String content;

    public Form(){}

    public Form(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
