package com.hanmaum.counseling.domain.emotion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor
public class EmotionCondition {

    @Min(1)@Max(31)
    private int month;

    @Min(1)@Max(12)
    private int year;
}
