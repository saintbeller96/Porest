package com.hanmaum.counseling.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.commons.ControllerTestConfig;
import com.hanmaum.counseling.domain.account.dto.SignupDto;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;

import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import com.hanmaum.counseling.utils.RedisUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
@Import(ControllerTestConfig.class)
class StoryControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    StoryService storyService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    void setUp(){
        User user = User.builder()
                .nickname("a")
                .email("user@test.com")
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();
        User counsellor = User.builder()
                .nickname("b")
                .email("counsellor1@test.com")
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();
        User counsellor2 = User.builder()
                .nickname("c")
                .email("counsellor2@test.com")
                .role(RoleType.ROLE_USER)
                .password(encoder.encode("1234"))
                .build();

        userRepository.save(user);
        userRepository.save(counsellor);

        storyService.putStory(new FormDto("첫번째 사연", "흑흑 너무 슬퍼요",null), user.getId());
        storyService.putStory(new FormDto("두번째 사연", "너무 힘드네요",null), user.getId());
    }

    @Test
    @DisplayName("사연 등록 성공시 201 반환")
    void put_story_success() throws Exception{
        //given
        User user = userRepository.findByEmail("user@test.com").get();
        FormDto form = new FormDto("사연 제목", "사연 내용", LocalDateTime.now());
        String content = mapper.writeValueAsString(form);
        //when
        ResultActions actions = mockMvc.perform(post("/stories")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user)))
        );
        //then
        actions.andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    @DisplayName("제목이 비어 있는 사연이 오면 400 반환")
    void put_story_fail() throws Exception{
        //given
        User user = userRepository.findByEmail("user@test.com").get();
        FormDto form = new FormDto("", "사연 내용", LocalDateTime.now());
        String content = mapper.writeValueAsString(form);
        //when
        ResultActions actions = mockMvc.perform(post("/stories")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user)))
        );
        //then
        actions.andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("선택할 후보 사연 가져오기 성공시 200 반환")
    void get_candidates_success() throws Exception{
        //given
        User counsellor = userRepository.findByEmail("counsellor1@test.com").get();
        //when
        ResultActions actions = mockMvc.perform(get("/stories/candidates")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(counsellor)))
        );
        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("사연 선택시 해당 사연 상세와 200 반환")
    void pick_story_success() throws Exception{
        //given
        User counsellor = userRepository.findByEmail("counsellor1@test.com").get();
        List<SimpleStoryDto> candidates = storyService.getCandidates(counsellor.getId());
        Long storyId = candidates.get(0).getStoryId();

        //when
        ResultActions actions = mockMvc.perform(post("/stories/" + storyId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(counsellor)))
        );

        //then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.counselId").isNumber())
                .andExpect(jsonPath("$.detail").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("없는 사연 선택시 404 반환")
    void pick_story_fail() throws Exception{
        //given
        User counsellor = userRepository.findByEmail("counsellor1@test.com").get();
        Long storyId = 10000L;
        //when
        ResultActions actions = mockMvc.perform(post("/stories/" + storyId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(counsellor)))
        );

        //then
        actions.andExpect(status().isNotFound())
                .andDo(print());
    }
}