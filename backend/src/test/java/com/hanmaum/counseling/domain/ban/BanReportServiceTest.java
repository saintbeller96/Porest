package com.hanmaum.counseling.domain.ban;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.ban.Ban;
import com.hanmaum.counseling.domain.model.ban.BanReport;
import com.hanmaum.counseling.domain.model.ban.BanReportStatus;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.domain.model.ban.BanReportRepository;
import com.hanmaum.counseling.domain.service.ban.BanReportServiceImpl;
import com.hanmaum.counseling.domain.service.ban.BanService;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.service.post.counsel.CounselService;
import com.hanmaum.counseling.error.BanReportNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class BanReportServiceTest {
    @Mock
    BanReportRepository mockBanReportRepository;
    @Mock
    BanService mockBanService;
    @Mock
    AccountService mockAccountService;
    @Mock
    CounselService mockCounselService;

    @InjectMocks
    BanReportServiceImpl banReportService;

    @BeforeEach
    void setUp() {


    }

    @Test
    @DisplayName("신고하기 성공")
    void banReportSuccess() throws Exception {
        //given
        Long reporterId = 1L;
        Long counselId = 1L;
        String banReason = "신고합니다.";
        given(mockAccountService.getUser(reporterId)).willReturn(createUser(reporterId));
        given(mockCounselService.getCounsel(counselId, reporterId)).willReturn(createCounsel(counselId));
        given(mockBanReportRepository.save(any(BanReport.class))).willReturn(BanReport.builder().build());
        //when
        BanReport report = banReportService.report(counselId, banReason, reporterId);
        //then
        Assertions.assertThat(report)
                .isInstanceOf(BanReport.class);
    }

    @Test
    @DisplayName("신고 처리하기 성공")
    void banReportProcessing() throws Exception {
        //given
        BanReport report = BanReport.builder().id(1L).banReason("신고합니다.").build();
        given(mockBanReportRepository.findById(1L)).willReturn(Optional.ofNullable(report));
        given(mockBanService.register(report)).willReturn(new Ban(null, report, LocalDateTime.now().plusDays(7L)));
        //when
        Ban ban = banReportService.process(1L);
        //then
        Assertions.assertThat(ban.getReport().getBanReportStatus()).isEqualTo(BanReportStatus.PROCESSED);
    }

    @Test
    @DisplayName("신고 처리하기 실패, 해당 신고 요청이 없는 경우")
    void test() throws Exception {
        //given
        Long banReportId = 2L;
        BanReport report = BanReport.builder().id(1L).banReason("신고합니다.").build();
        given(mockBanReportRepository.findById(banReportId)).willThrow(BanReportNotFoundException.class);
        //then
        Assertions.assertThatCode(()->banReportService.process(banReportId))
                .isInstanceOf(BanReportNotFoundException.class);
    }

    @Test
    @DisplayName("신고 취소하기 성공")
    void banReportCancel() throws Exception {
        //given
        BanReport report = BanReport.builder().id(1L).banReason("신고합니다.").build();
        given(mockBanReportRepository.findById(1L)).willReturn(Optional.ofNullable(report));
        //when
        Long cancelId = banReportService.cancel(1L);
        //then
        Assertions.assertThat(report.getBanReportStatus()).isEqualTo(BanReportStatus.CANCEL);
    }

    private User createUser(Long userId) {
        return User.builder()
                .id(userId)
                .email("user@porest.com")
                .build();
    }

    private Counsel createCounsel(Long counselId) {
        return Counsel.builder()
                .id(counselId)
                .build();
    }

}
