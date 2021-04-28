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

    @NotNull
    private Long storyId;

    @NotNull
    private Long letterId;

    private FormDto detail;

    public SimpleStoryDto(){}

    @Builder
    public SimpleStoryDto(Long storyId, Long letterId, String title, String content, LocalDateTime date){
        this.storyId = storyId;
        this.letterId = letterId;
        this.detail = new FormDto(title, content, date);
    }

    public SimpleStoryDto(Long storyId, String title, String content, LocalDateTime date){
        this.storyId = storyId;
        this.detail = new FormDto(title, content, date);
    }
}
