package com.hanmaum.counseling.domain.ban.service;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.ban.BanReportStatus;
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

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BanReportServiceImpl implements BanReportService{
    public final static int DEFAULT_BAN_PERIOD = 7;

    private final UserRepository userRepository;
    private final CounselRepository counselRepository;
    private final BanReportRepository banReportRepository;
    private final BanService banService;

    @Transactional
    @Override
    public BanReport report(Long counselId, String reason, Long reporterId) {
        User reporter = getUser(reporterId);
        Counsel counsel = getCounsel(counselId);
        return banReportRepository.save(new BanReport(reporter, counsel, reason, BanReportStatus.WAIT));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    private Counsel getCounsel(Long counselId) {
        return counselRepository.findByCounselId(counselId).orElseThrow();
    }

    @Transactional
    @Override
    public Ban process(Long banReportId) {
        BanReport banReport = banReportRepository.findById(banReportId)
                .orElseThrow();
        banReport.process();
        Ban ban = new Ban(banReport.getCounsellorUser(), banReport, LocalDateTime.now().plusDays(DEFAULT_BAN_PERIOD));
        return banService.register(ban);
    }

    @Transactional
    @Override
    public Long cancel(Long banReportId) {
        BanReport banReport = banReportRepository.findById(banReportId)
                .orElseThrow();
        banReport.cancel();
        return banReportId;
    }

    @Override
    public Page<BanReport> getWaitingBanReports(Pageable pageable) {
        return banReportRepository.findWaitingReport(pageable);
    }
}
