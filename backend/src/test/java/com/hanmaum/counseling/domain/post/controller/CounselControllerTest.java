package com.hanmaum.counseling.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.commons.ControllerTestConfig;
import com.hanmaum.counseling.domain.model.user.Password;
import com.hanmaum.counseling.domain.model.user.RoleType;
import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.user.UserRepository;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.domain.model.post.counsel.Counsel;
import com.hanmaum.counseling.domain.model.post.letter.Letter;
import com.hanmaum.counseling.domain.model.post.story.Story;
import com.hanmaum.counseling.api.post.dto.*;
import com.hanmaum.counseling.domain.service.post.letter.LetterService;
import com.hanmaum.counseling.domain.service.post.counsel.CounselService;
import com.hanmaum.counseling.domain.service.post.story.StoryService;
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
                .password(new Password("1234"))
                .build();
        User counsellor = User.builder()
                .nickname("b")
                .email("counsellor1@test.com")
                .temperature(36)
                .role(RoleType.ROLE_USER)
                .password(new Password("1234"))
                .build();
        User counsellor2 = User.builder()
                .nickname("c")
                .email("counsellor2@test.com")
                .temperature(36)
                .role(RoleType.ROLE_USER)
                .password(new Password("1234"))
                .build();

        userRepository.save(user);
        userRepository.save(counsellor);
        userRepository.save(counsellor2);

        Story story1 = storyService.putStory("????????? ??????", "?????? ?????? ?????????", user.getId());
        Story story2 = storyService.putStory("????????? ??????", "?????? ????????????", user.getId());

        //????????? ???????????? ????????? ????????? ??????
        Counsel counsel = storyService.pickStory(story1.getId(), counsellor.getId());

        Letter firstLetter = counsel.getLetters().get(0);

        //????????? ??????
        letterService.readLetter(firstLetter.getId(), counsellor.getId());
        //??????
        Letter reply = letterService.writeLetter("????????? ???????????? ???????????????", "??????????????? ??????", counsel.getId(), firstLetter.getId(), counsellor.getId());

        //???????????? ?????? ??????
        letterService.readLetter(reply.getId(), user.getId());
        Letter reply2 = letterService.writeLetter("???????????? ???????????????", "??? ?????? ???????????????.",
                counsel.getId(), reply.getId(), user.getId());

        //????????? ???????????? ????????? ????????? ??????
        SimpleCounselDto tempDto2;
        Counsel counsel2 = storyService.pickStory(story1.getId(), counsellor2.getId());

        Letter firstLetter2 = counsel2.getLetters().get(0);
        //????????? ??????
        letterService.readLetter(firstLetter2.getId(), counsellor2.getId());
        //??????
        letterService.writeLetter("????????? ???????????? ???????????????", "??????????????? ??????",
                counsel2.getId(), firstLetter2.getId(), counsellor2.getId());
    }
    @AfterEach
    void setDown(){
        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("????????? ????????? ????????? ?????? ?????? ??????, 200 ??????")
    void get_user_reply_status_success() throws Exception{
        //given
        User user = accountService.getUser("user@test.com");
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
    @DisplayName("????????? ????????? ?????? ????????? ?????? ??????, 200 ??????")
    void get_counsels_success() throws Exception{
        //given
        User user = accountService.getUser("user@test.com");
        List<Story> stories = storyService.getStoriesOfUser(user.getId());
        Long storyId = stories.get(0).getId();
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

        Assertions.assertThat(result).extracting("numOfReplies").containsExactly(1, 0);
    }
    @Test
    @DisplayName("????????? ?????? ?????? ????????? ?????? ??????, 200 ??????")
    void get_detail_counsel_success() throws Exception{
        //given
        User user = accountService.getUser("user@test.com");
        List<Counsel> result = counselService.getCounsels(user.getId());
        Long counselId = result.get(0).getId();
        //when
        ResultActions actions = mockMvc.perform(get("/counsels/" + counselId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    @DisplayName("????????? ???????????? ????????? ???????????? ???, 404 ??????")
    void get_detail_counsel_fail() throws Exception{
        //given
        User user = accountService.getUser("user@test.com");
        //when
        ResultActions actions = mockMvc.perform(get("/counsels/"+404L)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));

        //then
        actions.andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    @DisplayName("????????? ???????????? ?????? ??????, 200 ??????")
    void get_user_counsel_state_success() throws Exception{
        //given
        User user = accountService.getUser("counsellor1@test.com");
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
    @DisplayName("?????? ??????, 200 ??????")
    void finish_counsel() throws Exception{
        //given
        User user = accountService.getUser("user@test.com");
        List<Story> storiesOfUser = storyService.getStoriesOfUser(user.getId());
        Story story = storiesOfUser.get(0);
        //List<UserCounselStateDto> temp2 =
        Story storyOfUser = storyService.getStoryOfUser(story.getId(), user.getId());
        Counsel counsel = storyOfUser.getCounsels().get(0);
        EvaluateDto dto = new EvaluateDto(true, EvaluateDto.EvaluateType.GOOD);
        String content = mapper.writeValueAsString(dto);
        //when
        ResultActions actions = mockMvc.perform(post("/counsels/" + counsel.getId() + "/finish")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }
}