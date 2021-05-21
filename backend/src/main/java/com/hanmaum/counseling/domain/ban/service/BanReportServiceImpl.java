package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.domain.ban.dto.BanReportDto;
import com.hanmaum.counseling.domain.ban.entity.Ban;
import com.hanmaum.counseling.domain.ban.entity.BanReport;
import com.hanmaum.counseling.domain.ban.entity.BanStatus;
import com.hanmaum.counseling.domain.ban.repository.BanReportRepository;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import com.hanmaum.counseling.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BanReportServiceImpl implements BanReportService{

    private final BanReportRepository banReportRepository;
    private final BanRepository banRepository;
    private final CounselRepository counselRepository;

    @Override
    public Long reportBan(BanReportDto reportDto) {
        Long reporterId = getCurrentUserId();
        BanReport report = BanReport.of(reportDto, reporterId);
        return banReportRepository.save(report).getId();
    }

    private Long getCurrentUserId() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    @Override
    public Long processReport(Long banReportId) {
        BanReport banReport = banReportRepository.findById(banReportId).orElseThrow();
        banReport.process();

        Counsel counsel = counselRepository.findByCounselId(banReport.getCounselId()).orElseThrow();

        Ban ban = Ban.builder()
                .banStatus(BanStatus.BANNED)
                .banUserId(counsel.getCounsellorId())
                .report(banReport)
                .releaseDate(LocalDateTime.now().plusDays(Ban.BAN_PERIOD))
                .build();
        return banRepository.save(ban).getId();
    }

    @Override
    public Long cancelReport(Long banReportId) {
        BanReport banReport = banReportRepository.findById(banReportId).orElseThrow();
        banReport.cancel();
        return banReportId;
    }

    @Override
    public Page<BanReportDetailDto> getProceedingBanReports(Pageable pageable) {
        return banReportRepository.findProceedingReport(pageable);
    }
}
