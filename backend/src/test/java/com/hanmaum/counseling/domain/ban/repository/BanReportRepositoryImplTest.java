package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.domain.ban.dto.BanReportDto;
import com.hanmaum.counseling.domain.ban.entity.BanReport;
import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.repository.counsel.CounselRepository;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

//@DataJpaTest
@SpringBootTest
@Transactional
@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BanReportRepositoryImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    BanReportRepository banReportRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CounselService counselService;
    @Autowired
    StoryService storyService;
    @Autowired
    LetterService letterService;

    @BeforeEach
    void setUp() {
        User reporter = User.builder()
                .temperature(36).role(RoleType.ROLE_USER)
                .email("reporter@test.com").password("1234").nickname("reporter").build();

        User reported = User.builder()
                .temperature(36).role(RoleType.ROLE_USER)
                .email("counsellor@test.com").password("1234").nickname("reported").build();
        userRepository.save(reporter);
        userRepository.save(reported);

        setUpCounselStatus(reporter, reported);
    }

    void setUpCounselStatus(User reporter, User counsellor) {
        Long storyId = storyService.putStory(new FormDto("첫번째 사연의 제목", "너무 힘들어요, 어떻게 해야 하죠", null), reporter.getId());
        SimpleCounselDto counselDto = storyService.pickStory(storyId, counsellor.getId());
        Long counselId = counselDto.getCounselId();
        Long letterId = counselDto.getDetail().getLetterId();

        //상담사 편지 작성
        Long letterId2 = letterService.writeLetter(new FormDto("첫번째 답장", "그러시군요 ㅠㅠ", null), counselId, letterId, counsellor.getId());

        //사연자가 편지 읽음
        letterService.readLetter(letterId2, reporter.getId());
    }

    @Test
    @DisplayName("신고 요청 생성 성공")
    void create_counsel() throws Exception{
        //given
        User reporter = userRepository.findByEmail("reporter@test.com").get();
        User counsellor = userRepository.findByEmail("counsellor@test.com").get();
        List<UserStoryStateDto> c = storyService.getUserStoryState(reporter.getId());
        Long storyId = c.get(0).getStoryId();
        List<UserCounselStateDto> d = counselService.getCounselStateOfUser(counsellor.getId());
        Long counselId = d.get(0).getCounselId();
        BanReport banReport = BanReport.of(new BanReportDto(counselId,"너무 성의가 없네요"), reporter.getId());
        //when
        BanReport save = banReportRepository.save(banReport);
        //then
        Assertions.assertThat(banReport).isEqualTo(save);
    }

    @Test
    @DisplayName("신고 목록 가져오기")
    void test() throws Exception{
        //given
        User reporter = userRepository.findByEmail("reporter@test.com").get();
        User counsellor = userRepository.findByEmail("counsellor@test.com").get();
        List<UserStoryStateDto> c = storyService.getUserStoryState(reporter.getId());
        Long storyId = c.get(0).getStoryId();
        List<UserCounselStateDto> d = counselService.getCounselStateOfUser(counsellor.getId());
        Long counselId = d.get(0).getCounselId();

        BanReport banReport = BanReport.of(new BanReportDto(counselId,"너무 성의가 없네요"), reporter.getId());
        //when
        BanReport save = banReportRepository.save(banReport);

        //when
        Page<BanReportDetailDto> result = banReportRepository.findProceedingReport(PageRequest.of(0, 10));

        //then
        Assertions.assertThat(result.getContent().size()).isEqualTo(1);
        //
    }
}