package com.hanmaum.counseling.domain.service.ban;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.domain.model.ban.BanReportStatus;
import com.hanmaum.counseling.domain.service.post.counsel.CounselService;
import com.hanmaum.counseling.error.BanReportNotFoundException;
import com.hanmaum.counseling.domain.model.ban.Ban;
import com.hanmaum.counseling.domain.model.ban.BanReport;
import com.hanmaum.counseling.domain.model.ban.BanReportRepository;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
