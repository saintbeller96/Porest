package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostContent {
    private Long postId;
    private FormDto letter;
    private FormDto reply;

    public PostContent(){};
    public PostContent(Long postId, String letterTitle, String letterContent, LocalDateTime letterDate,
                          String replyTitle, String replyContent, LocalDateTime replyDate){
        this.postId = postId;
        this.letter = new FormDto(letterTitle, letterContent, letterDate);
        this.reply = new FormDto(replyTitle, replyContent, replyDate);
    }
}
