package com.hanmaum.counseling.domain.ban.controller;

import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.domain.ban.dto.BanReportDto;
import com.hanmaum.counseling.domain.ban.service.BanReportService;
import com.hanmaum.counseling.domain.ban.service.BanService;
import com.hanmaum.counseling.security.CustomUserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"Ban"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/bans")
public class BanController {
    private final BanService banService;
    private final BanReportService banReportService;

    @ApiOperation("신고하기")
    @PostMapping("")
    public ResponseEntity<?> reportBan(@RequestBody @Valid BanReportDto banReportDto) {
        banReportService.reportBan(banReportDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("신고 요청 처리하기")
    @PutMapping("/{banReportId}")
    public ResponseEntity<?> processBanReport(@PathVariable("banReportId") Long banReportId) {
        banReportService.processReport(banReportId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("신고 요청 취소하기")
    @PutMapping("/{banReportId}/cancel")
    public ResponseEntity<?> cancelBanReport(@PathVariable("banReportId") Long banReportId) {
        banReportService.cancelReport(banReportId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("신고 요청 페이징 목록 반환")
    @GetMapping("")
    public ResponseEntity<Page<BanReportDetailDto>> getPageOfBanReport(Pageable pageable) {
        Page<BanReportDetailDto> result = banReportService.getProceedingBanReports(pageable);
        return ResponseEntity.ok(result);
    }

}
