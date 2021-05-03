package com.hanmaum.counseling.domain.post.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class DetailCounselDto {
    private Long counselId;
    private List<LetterReplyDto> detail;

    public DetailCounselDto(){
        detail = new ArrayList<>();
    }

    public void setCounselId(Long counselId){
        this.counselId = counselId;
    }
}
