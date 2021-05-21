package com.hanmaum.counseling.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 사연을 뽑거나 선택할 때 사용할 Dto
 * 작성자: 김종성
 */
@Getter
@ToString
public class SimpleStoryDto {

    private Long storyId;

    private FormDto detail;

    public SimpleStoryDto(){}

    @Builder
    public SimpleStoryDto(Long storyId, String title, String content, LocalDateTime date){
        this.storyId = storyId;
        this.detail = FormDto.builder().title(title).content(content).createAt(date).build();
    }
}
