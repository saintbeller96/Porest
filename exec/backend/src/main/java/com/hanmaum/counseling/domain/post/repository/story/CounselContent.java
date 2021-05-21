package com.hanmaum.counseling.domain.post.repository.story;

import com.hanmaum.counseling.domain.post.dto.FormDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CounselContent {
    private Long counselId;
    private FormDto letter;
    private FormDto reply;

    public CounselContent(){};
    public CounselContent(Long counselId, Long letterId, String letterTitle, String letterContent, LocalDateTime letterDate,
                          Long replyId, String replyTitle, String replyContent, LocalDateTime replyDate){
        this.counselId = counselId;
        this.letter = new FormDto(letterTitle, letterContent, letterDate);
        this.reply = new FormDto(replyTitle, replyContent, replyDate);
    }
}
