package com.hanmaum.counseling.domain.ban;


import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.ban.Ban;
import com.hanmaum.counseling.domain.model.ban.BanRepository;
import com.hanmaum.counseling.domain.service.ban.BanServiceImpl;
import com.hanmaum.counseling.error.BannedUserException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BanServiceTest {
    @Mock
    BanRepository mockBanRepository;

    @InjectMocks
    BanServiceImpl banService;

    @Test
    @DisplayName("유저의 계정 정지 상태 확인, 성공")
    void validateUserState() throws Exception {
        //given
        User banUser = createUser(1L);
        Ban ban1 = new Ban(banUser, null, LocalDateTime.now().plusDays(3L));
        Ban ban2 = new Ban(banUser, null, LocalDateTime.now().plusDays(5L));
        given(mockBanRepository.findByUserId(1L)).willReturn(Arrays.asList(ban1, ban2));
        //when
        //then
        Assertions.assertThatCode(()->banService.validateUserBanState(banUser))
                .isInstanceOf(BannedUserException.class);
    }

    @Test
    @DisplayName("유저의 계정 정지 상태 확인, 정지 기간이 지난 경우 성공")
    void validateUserStateNotExpire() throws Exception {
        //given
        User banUser = createUser(1L);
        Ban ban1 = new Ban(banUser, null, LocalDateTime.now().minusDays(3L));
        Ban ban2 = new Ban(banUser, null, LocalDateTime.now().minusDays(5L));
        given(mockBanRepository.findByUserId(1L)).willReturn(Arrays.asList(ban1, ban2));
        //when
        //then
        Assertions.assertThatCode(()->banService.validateUserBanState(banUser))
                .doesNotThrowAnyException();
    }

    private User createUser(Long userId) {
        return User.builder()
                .id(userId)
                .build();
    }

}
