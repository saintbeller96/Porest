package com.hanmaum.counseling.api.account.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RedundancyDto {
    private boolean Redundancy;

    public RedundancyDto(boolean redundancy) {
        Redundancy = redundancy;
    }

    public static RedundancyDto of(boolean redundancy){
        return new RedundancyDto(redundancy);
    }
}
