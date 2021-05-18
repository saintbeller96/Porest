package com.hanmaum.counseling.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.commons.ControllerTestConfig;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.post.dto.*;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.counsel.CounselService;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@Import(ControllerTestConfig.class)
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
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp(){
        User user = User.builder()
                .nickname("a")
                .email("user@test.com")
                .temperature(36)
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();
        User counsellor = User.builder()
                .nickname("b")
                .email("counsellor1@test.com")
                .temperature(36)
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();
        User counsellor2 = User.builder()
                .nickname("c")
                .email("counsellor2@test.com")
                .temperature(36)
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();

        userRepository.save(user);
        userRepository.save(counsellor);
        userRepository.save(counsellor2);

        Long storyId = storyService.putStory(new FormDto("첫번째 사연", "흑흑 너무 슬퍼요", null), user.getId());
        Long storyId2 = storyService.putStory(new FormDto("두번째 사연", "너무 힘드네요", null), user.getId());

        //첫번째 상담사가 첫번째 사연을 선택
        SimpleCounselDto tempDto = storyService.pickStory(storyId, counsellor.getId());
        //사연을 읽음
        letterService.readLetter(tempDto.getDetail().getLetterId(), counsellor.getId());
        //답장
        Long letterId1 = letterService.writeLetter(new FormDto( "첫번째 상담사의 답변입니다", "그러시군요 ㅠㅠ", null),
                tempDto.getCounselId(), tempDto.getDetail().getLetterId(), counsellor.getId());

        //사연자가 다시 답장
        letterService.readLetter(letterId1, user.getId());
        Long replyId1 = letterService.writeLetter(new FormDto("사연자의 답변입니다", "네 정말 고맙습니다.", null),
                tempDto.getCounselId(), letterId1, user.getId());


        //두번째 상담사가 첫번째 사연을 선택
        SimpleCounselDto tempDto2 = storyService.pickStory(storyId, counsellor2.getId());
        //사연을 읽음
        letterService.readLetter(tempDto2.getDetail().getLetterId(), counsellor2.getId());
        //답장
        Long letterId2 = letterService.writeLetter(new FormDto("두번째 상담사의 답변입니다", "그러시군요 ㅋㅋ", null),
                tempDto2.getCounselId(), tempDto2.getDetail().getLetterId(), counsellor2.getId());
    }
    @AfterEach
    void setDown(){
        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("유저가 작성한 사연의 답장 상태 제공, 200 반환")
    void get_user_reply_status_success() throws Exception{
        //given
        User user = accountService.findByEmail("user@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/stories")
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        MvcResult mvcResult = actions.andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        List<UserStoryStateDto> result = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, UserStoryStateDto.class));
        Assertions.assertThat(result).extracting("numOfNewReply").containsExactly(1, 0);
    }
    
    @Test
    @DisplayName("유저가 작성한 사연 하나의 답장 내역, 200 반환")
    void get_counsels_success() throws Exception{
        //given
        User user = accountService.findByEmail("user@test.com");
        List<UserStoryStateDto> userStoryState = storyService.getUserStoryState(user.getId());
        Long storyId = userStoryState.get(0).getStoryId();
        //when
        ResultActions actions = mockMvc.perform(get("/stories/" + storyId + "/counsels")
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        MvcResult mvcResult = actions.andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        List<UserCounselStateDto> result = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, UserCounselStateDto.class));

        Assertions.assertThat(result).extracting("numOfReplies").containsExactly(0, 1);
    }
    @Test
    @DisplayName("자신이 보낸 특정 사연의 상담 내역, 200 반환")
    void get_detail_counsel_success() throws Exception{
        //given
        User user = accountService.findByEmail("user@test.com");
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
        User user = accountService.findByEmail("user@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/counsels/"+404L)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    @DisplayName("유저가 상담중인 상담 상태, 200 반환")
    void get_user_counsel_state_success() throws Exception{
        //given
        User user = accountService.findByEmail("counsellor1@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/counsels")
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        MvcResult mvcResult = actions.andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        List<UserCounselStateDto> result = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, UserCounselStateDto.class));
        Assertions.assertThat(result).extracting("numOfReplies").containsExactly(1);
    }

    @Test
    @DisplayName("상담 종료, 200 반환")
    void finish_counsel() throws Exception{
        //given
        User user = accountService.findByEmail("user@test.com");
        List<UserStoryStateDto> temp1 = storyService.getUserStoryState(user.getId());
        Long storyId = temp1.get(0).getStoryId();
        List<UserCounselStateDto> temp2 = storyService.getCounselStateOfUserWithStory(storyId, user.getId());
        Long counselId = temp2.get(0).getCounselId();
        EvaluateDto dto = new EvaluateDto(true, EvaluateDto.EvaluateType.GOOD);
        String content = mapper.writeValueAsString(dto);
        //when
        ResultActions actions = mockMvc.perform(post("/counsels/" + counselId + "/finish")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        actions.andExpect(status().isOk())
                .andDo(print());

        List<UserCounselStateDto> temp3 = storyService.getCounselStateOfUserWithStory(storyId, user.getId());
        Assertions.assertThat(temp3.size()).isEqualTo(1);
    }
}