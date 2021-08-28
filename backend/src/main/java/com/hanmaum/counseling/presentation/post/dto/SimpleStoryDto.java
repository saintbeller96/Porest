package com.hanmaum.counseling.presentation.post.dto;

import com.hanmaum.counseling.domain.post.story.Story;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

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

    public static SimpleStoryDto of(Story story) {
        return SimpleStoryDto.builder()
                .storyId(story.getId())
                .title(story.getTitle())
                .content(story.getContent())
                .date(story.getCreatedAt())
                .build();
    }
}
