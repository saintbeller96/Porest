package com.hanmaum.counseling.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;


/**
 * 제목과 내용 작성일이 저장됨
 * 편지, 답장에 사용
 * 작성자: 김종성
 */
@Getter
@NoArgsConstructor
@ToString
public class FormDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @PastOrPresent
    private LocalDateTime createAt;

    @Builder
    public FormDto(@NotBlank String title, @NotBlank String content, @PastOrPresent LocalDateTime createAt) {
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }
}
