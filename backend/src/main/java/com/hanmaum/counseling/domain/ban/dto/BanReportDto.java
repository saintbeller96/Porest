package com.hanmaum.counseling.domain.ban.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BanReportDto {
    @NotNull
    private Long counselId;
    private String banReason;
}
