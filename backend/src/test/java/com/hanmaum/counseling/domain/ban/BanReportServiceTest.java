package com.hanmaum.counseling.domain.ban;

import com.hanmaum.counseling.domain.account.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.ban.repository.BanReportRepository;
import com.hanmaum.counseling.domain.ban.service.BanReportService;
import com.hanmaum.counseling.domain.post.counsel.repository.CounselRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class BanReportServiceTest {
    @Mock
    BanReportRepository mockBanReportRepository;
    @Mock
    CounselRepository mockCounselRepository;
    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    BanReportService banReportService;

    @BeforeEach
    void setUp() {


    }

    @Test
    @DisplayName("신고하기")
    void banReportSuccess() throws Exception {
        //given
        given(mockUserRepository.findById(1L)).willReturn(Optional.of(new User()));
        //when

        //then

    }

    @Test
    @DisplayName("신고 처리하기")
    void banReportProcessing() throws Exception {
        //given

        //when

        //then

    }

    @Test
    @DisplayName("신고 취소하기")
    void banReportCancel() throws Exception {
        //given

        //when

        //then

    }

}
