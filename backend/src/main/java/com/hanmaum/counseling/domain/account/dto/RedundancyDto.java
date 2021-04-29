package com.hanmaum.counseling.domain.account.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RedundancyDto {
    private boolean Redundancy;

    @Builder
    public RedundancyDto(boolean redundancy) {
        Redundancy = redundancy;
    }
}
