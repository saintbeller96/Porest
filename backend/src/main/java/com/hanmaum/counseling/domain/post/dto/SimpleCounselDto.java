package com.hanmaum.counseling.domain.post.dto;

import com.hanmaum.counseling.domain.post.entity.Letter;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@ToString
public class SimpleCounselDto {
    @NotNull
    private Long counselId;
    @NotNull
    private Long letterId;
    private FormDto detail;

    public SimpleCounselDto(){}

    @Builder
    public SimpleCounselDto(Long counselId, Long letterId, String title, String content, LocalDateTime date){
        this.counselId = counselId;
        this.letterId = letterId;
        this.detail = new FormDto(title, content, date);
    }

    public static SimpleCounselDto create(Long counselId, Letter letter){
        return SimpleCounselDto.builder()
                .counselId(counselId)
                .letterId(letter.getId())
                .title(letter.getForm().getTitle())
                .content(letter.getForm().getContent())
                .date(letter.getCreatedAt())
                .build();

    }
}
