package com.hanmaum.counseling.domain.post.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class DetailStoryDto {
    private Long postId;
    private List<LetterReplyDto> detail;
}
