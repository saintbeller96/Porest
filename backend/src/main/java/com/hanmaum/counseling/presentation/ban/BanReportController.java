package com.hanmaum.counseling.presentation.ban;

import com.hanmaum.counseling.domain.ban.BanReport;
import com.hanmaum.counseling.domain.ban.service.BanReportService;
import com.hanmaum.counseling.presentation.argumentresolver.LoginUserId;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"BanReport"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/ban-reports")
public class BanReportController {

    private final BanReportService banReportService;

    @ApiOperation("신고하기")
    @PostMapping("")
    public ResponseEntity<?> reportBan(@RequestBody @Valid BanReportDto banReportDto, @LoginUserId Long userId) {
        BanReport report = banReportService.report(banReportDto.getCounselId(), banReportDto.getBanReason(), userId);
        return ResponseEntity.ok(BanReportDetailDto.of(report));
    }

    @ApiOperation("신고 요청 처리하기")
    @PutMapping("/{banReportId}")
    public ResponseEntity<?> processBanReport(@PathVariable("banReportId") Long banReportId) {
        banReportService.process(banReportId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("신고 요청 취소하기")
    @PutMapping("/{banReportId}/cancel")
    public ResponseEntity<?> cancelBanReport(@PathVariable("banReportId") Long banReportId) {
        banReportService.cancel(banReportId);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("신고 요청 페이징 목록 반환")
    @GetMapping("")
    public ResponseEntity<Page<BanReportDetailDto>> getPageOfBanReport(Pageable pageable) {
        Page<BanReport> result = banReportService.getWaitingBanReports(pageable);
        return ResponseEntity.ok(result.map(BanReportDetailDto::of));
    }
}
