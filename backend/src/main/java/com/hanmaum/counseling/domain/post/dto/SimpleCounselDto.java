package com.hanmaum.counseling.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
public class SimpleCounselDto {
    @NotNull
    private Long postId;
    @NotNull
    private Long letterId;
    private FormDto detail;

    public SimpleCounselDto(){}

    @Builder
    public SimpleCounselDto(Long postId, Long letterId, String title, String content, LocalDateTime date){
        this.postId = postId;
        this.letterId = letterId;
        this.detail = new FormDto(title, content, date);
    }
}
