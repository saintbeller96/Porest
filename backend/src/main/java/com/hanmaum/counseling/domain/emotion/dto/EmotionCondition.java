package com.hanmaum.counseling.domain.emotion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
public class EmotionCondition {
    @Min(1)@Max(12)
    private int month;

    @Min(2000)@Max(2021)
    private int year;
}
