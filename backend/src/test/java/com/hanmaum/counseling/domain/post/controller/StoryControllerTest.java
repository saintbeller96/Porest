package com.hanmaum.counseling.domain.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.commons.ControllerTestConfig;
import com.hanmaum.counseling.domain.account.dto.SignupDto;
import com.hanmaum.counseling.domain.account.entity.User;

import com.hanmaum.counseling.domain.account.service.AccountService;
import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.service.story.StoryService;
import com.hanmaum.counseling.security.CustomUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
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
    AccountService accountService;

    @Autowired
    ObjectMapper mapper;

    User user;
    User counsellor;

    @BeforeEach
    void setUp(){
        SignupDto dto = SignupDto.builder()
                .email("test@test.com")
                .password("1234")
                .nickname("사연자")
                .build();
        user = accountService.saveUser(dto);

        SignupDto dto2 = SignupDto.builder()
                .email("test2@test.com")
                .password("1234")
                .nickname("상담사")
                .build();
        counsellor = accountService.saveUser(dto2);

        storyService.putStory(new FormDto("첫번째 사연", "흑흑 너무 슬퍼요",null), user.getId());
        storyService.putStory(new FormDto("두번째 사연", "너무 힘드네요",null), user.getId());
    }

    @Test
    @DisplayName("사연 등록 성공시 201 반환")
    void put_story_success() throws Exception{
        //given
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
                .andExpect(jsonPath("$.letterId").isNumber())
                .andExpect(jsonPath("$.detail").isNotEmpty())
                .andDo(print());
    }

    @Test
    @DisplayName("없는 사연 선택시 404 반환")
    void pick_story_fail() throws Exception{
        //given
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

    @Test
    @DisplayName("사연과 관련된 모든 편지 내용 가져오고 200 반환")
    void test() throws Exception{
        //given

        Long storyId = 1L;
        //when
        ResultActions actions = mockMvc.perform(get("/stories/" + storyId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(counsellor)))
        );
        //then
        actions.andExpect(status().isOk())
                .andDo(print());
    }



}