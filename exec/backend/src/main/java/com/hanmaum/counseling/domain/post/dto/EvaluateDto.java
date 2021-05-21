package com.hanmaum.counseling.domain.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EvaluateDto {
    public enum EvaluateType{
        BAD(-2), NORMAL(0), GOOD(1);
        private int score;
        public int getScore(){
            return score;
        }
        EvaluateType(int i) {
            this.score = i;
        }
    }
    private boolean open;
    private EvaluateType evaluate;

    public EvaluateDto(boolean open, EvaluateType evaluate) {
        this.open = open;
        this.evaluate = evaluate;
    }
}
