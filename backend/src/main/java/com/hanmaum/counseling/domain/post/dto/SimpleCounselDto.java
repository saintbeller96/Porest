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
    private LetterDto detail;

    public SimpleCounselDto(){}

    @Builder
    public SimpleCounselDto(Long counselId, Letter letter){
        this.counselId = counselId;
        this.detail = LetterDto.of(letter);
    }

    public static SimpleCounselDto create(Long counselId, Letter letter){
        return SimpleCounselDto.builder()
                .counselId(counselId)
                .letter(letter)
                .build();
    }
}
