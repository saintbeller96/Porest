package com.hanmaum.counseling.domain.post.controller;

import com.hanmaum.counseling.domain.account.dto.SignupDto;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.post.dto.DetailCounselDto;
import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleCounselDto;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class CounselControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    StoryService storyService;
    @Autowired
    AccountService accountService;
    @Autowired
    CounselService counselService;
    @Autowired
    LetterService letterService;
    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp(){
        SignupDto dto = SignupDto.builder()
                .email("test@test.com")
                .password("1234")
                .nickname("사연자")
                .build();
        User user = accountService.saveUser(dto);

        SignupDto dto2 = SignupDto.builder()
                .email("test2@test.com")
                .password("1234")
                .nickname("상담사1")
                .build();
        User counsellor = accountService.saveUser(dto2);

        SignupDto dto3 = SignupDto.builder()
                .email("test3@test.com")
                .password("1234")
                .nickname("상담사2")
                .build();
        User counsellor2 = accountService.saveUser(dto3);

        Long storyId = storyService.putStory(new FormDto("첫번째 사연", "흑흑 너무 슬퍼요", null), user.getId());
        Long storyId2 = storyService.putStory(new FormDto("두번째 사연", "너무 힘드네요", null), user.getId());

        //첫번째 상담사가 첫번째 사연을 선택
        SimpleCounselDto tempDto = storyService.pickStory(storyId, counsellor.getId());
        //사연을 읽음
        letterService.readLetter(tempDto.getLetterId(), counsellor.getId());
        //답장
        Long letterId1 = letterService.writeLetter(new FormDto("첫번째 상담사의 답변입니다", "그러시군요 ㅠㅠ", null),
                tempDto.getCounselId(), tempDto.getLetterId(), counsellor.getId());

        //두번째 상담사가 첫번째 사연을 선택
        SimpleCounselDto tempDto2 = storyService.pickStory(storyId, counsellor.getId());
        //사연을 읽음
        letterService.readLetter(tempDto2.getLetterId(), counsellor.getId());
        //답장
        Long letterId2 = letterService.writeLetter(new FormDto("두번째 상담사의 답변입니다", "그러시군요 ㅋㅋ", null),
                tempDto2.getCounselId(), tempDto2.getLetterId(), counsellor2.getId());
    }
    @AfterEach
    void clear(){
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저의 답장 상태 제공 200 반환")
    void get_user_reply_status_success() throws Exception{
        //given
        User user = accountService.findByEmail("test@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/stories")
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then

        actions.andExpect(status().isOk())
                .andDo(print());
    }
    
    @Test
    @DisplayName("자신이 보낸 모든 사연의 상세 내용들, 200 반환")
    void get_counsels_success() throws Exception{
        //given
        User user = accountService.findByEmail("test@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/counsels")
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    @DisplayName("자신이 보낸 특정 사연의 상세 내용들, 200 반환")
    void get_detail_counsel_success() throws Exception{
        //given
        User user = accountService.findByEmail("test@test.com");
        List<DetailCounselDto> result = counselService.getDetailCounsels(user.getId());
        Long counselId = result.get(0).getCounselId();
        //when
        ResultActions actions = mockMvc.perform(get("/counsels/" + counselId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    @DisplayName("자신과 관련없는 사연을 요청했을 때, 404 반환")
    void get_detail_counsel_fail() throws Exception{
        //given
        User user = accountService.findByEmail("test@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/counsels/"+404L)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isNotFound())
                .andDo(print());
    }
}