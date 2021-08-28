package com.hanmaum.counseling.presentation.post.dto;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.letter.Letter;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

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

    public static SimpleCounselDto of(Counsel counsel){
        return SimpleCounselDto.builder()
                .counselId(counsel.getId())
                .letter(counsel.getLetters().get(0))
                .build();
    }
}
