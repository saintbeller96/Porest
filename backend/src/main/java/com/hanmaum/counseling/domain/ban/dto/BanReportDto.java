package com.hanmaum.counseling.domain.ban.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class BanReportDto {
    @NotNull
    private Long counselId;
    private String banReason;
}
