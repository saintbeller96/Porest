package com.hanmaum.counseling.domain.post.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DetailStoryDto {
    private Long postId;
    private List<LetterReplyDto> detail;

    public DetailStoryDto(){
        detail = new ArrayList<>();
    }

    public void setPostId(Long postId){
        this.postId = postId;
    }
}
