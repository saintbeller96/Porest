package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.ban.BanReportStatus;
import com.hanmaum.counseling.domain.post.counsel.service.CounselService;
import com.hanmaum.counseling.error.BanReportNotFoundException;
import com.hanmaum.counseling.error.CounselNotFoundException;
import com.hanmaum.counseling.error.UserNotFoundException;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.presentation.ban.dto.BanReportDto;
import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.BanReport;
import com.hanmaum.counseling.domain.ban.BanStatus;
import com.hanmaum.counseling.domain.ban.repository.BanReportRepository;
import com.hanmaum.counseling.domain.ban.repository.BanRepository;
import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.counsel.repository.CounselRepository;
import com.hanmaum.counseling.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class BanReportServiceImpl implements BanReportService{

    private final BanReportRepository banReportRepository;
    private final AccountService accountService;
    private final CounselService counselService;
    private final BanService banService;
    
    @Override
    public BanReport report(Long counselId, String reason, Long reporterId) {
        User reporter = accountService.getUser(reporterId);
        Counsel counsel = counselService.getCounsel(counselId, reporterId);
        return banReportRepository.save(BanReport.builder()
                .reporter(reporter)
                .counsel(counsel)
                .banReason(reason)
                .banReportStatus(BanReportStatus.WAIT)
                .build());
    }

    @Override
    public Ban process(Long banReportId) {
        BanReport banReport = getBanReport(banReportId);
        banReport.process();
        return banService.register(banReport);
    }

    @Override
    public Long cancel(Long banReportId) {
        BanReport banReport = getBanReport(banReportId);
        banReport.cancel();
        return banReportId;
    }

    private BanReport getBanReport(Long banReportId) {
        return banReportRepository.findById(banReportId)
                .orElseThrow(BanReportNotFoundException::new);
    }

    @Override
    public Page<BanReport> getWaitingBanReports(Pageable pageable) {
        return banReportRepository.findWaitingReport(pageable);
    }
}
