package com.hanmaum.counseling.domain.post.dto;

import com.hanmaum.counseling.domain.post.repository.story.PostContent;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
public class LetterReplyDto {
    @NotNull
    private FormDto letter;
    private FormDto reply;

    public LetterReplyDto(){};

    @Builder
    public LetterReplyDto(String letterTitle, String letterContent, LocalDateTime letterDate,
                          String replyTitle, String replyContent, LocalDateTime replyDate){
        this.letter = new FormDto(letterTitle, letterContent, letterDate);
        this.reply = new FormDto(replyTitle, replyContent, replyDate);
    }

    public static LetterReplyDto convert(PostContent pc){
        return LetterReplyDto.builder()
                .letterTitle(pc.getLetter().getTitle())
                .letterContent(pc.getLetter().getContent())
                .letterDate(pc.getLetter().getCreateAt())
                .replyTitle(pc.getReply().getTitle())
                .replyContent(pc.getReply().getContent())
                .replyDate(pc.getReply().getCreateAt())
                .build();
    }
}
