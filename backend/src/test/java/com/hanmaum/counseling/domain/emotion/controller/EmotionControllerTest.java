package com.hanmaum.counseling.domain.emotion.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.domain.account.entity.RoleType;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.account.repository.UserRepository;
import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionDetailDto;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.emotion.service.EmotionService;
import com.hanmaum.counseling.commons.ControllerTestConfig;
import com.hanmaum.counseling.security.CustomUserDetails;
import org.assertj.core.api.Assertions;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

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
@Import(ControllerTestConfig.class)
@ActiveProfiles("test")
class EmotionControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    EmotionService emotionService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper mapper;

    User user;
    @BeforeEach
    void setUp(){
        user = userRepository.save(User.builder().email("test@test.com")
                .role(RoleType.ROLE_USER)
                .password("1234")
                .nickname("nickname").build());
    }

    EmotionDetailDto setUpEmotion(){
        return EmotionDetailDto.builder()
                .content("content")
                .feeling(1)
                .imageUrl("url").build();
    }

    @Test
    @DisplayName("감정 기록 저장 성공시 201")
    void saveEmotion() throws Exception{
        //given
        String content = mapper.writeValueAsString(setUpEmotion());
        //when
        ResultActions actions = mockMvc.perform(post("/emotions")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        actions.andExpect(status().isCreated());
    }

    @Test
    @DisplayName("오늘 감정 기록을 2번 이상 하는 경우 404 반환")
    void saveDuplicatedEmotion() throws Exception{
        //given
        EmotionDetailDto dto = setUpEmotion();
        emotionService.saveEmotion(dto, user.getId());

        String content = mapper.writeValueAsString(dto);
        //when
        ResultActions actions = mockMvc.perform(post("/emotions")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        actions.andExpect(status().isNotFound())
        .andDo(print());
    }

    @Test
    @DisplayName("Emotion Id로 감정 기록 가져오기 성공 200")
    void getEmotionDetail() throws Exception{
        //given
        var temp = setUpEmotion();
        Long emotionId = emotionService.saveEmotion(temp, user.getId());

        //when
        ResultActions actions = mockMvc.perform(get("/emotions/" + emotionId)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        MvcResult result = actions.andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        EmotionDetailDto resultDto = mapper.readValue(content, EmotionDetailDto.class);

        Assertions.assertThat(resultDto.getContent()).isEqualTo(temp.getContent());
    }

    @Test
    @DisplayName("입력된 년/월의 모든 감정 기록 가져오기 성공시 200")
    void searchEmotions() throws Exception{
        //given
        EmotionDetailDto dto = setUpEmotion();
        Long emotionId = emotionService.saveEmotion(dto, user.getId());

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("month", "5");
        param.add("year", "2021");
        //when
        ResultActions actions = mockMvc.perform(get("/emotions")
                .queryParams(param)
                .contentType(MediaType.APPLICATION_JSON)
                .with(user(CustomUserDetails.fromUserToCustomUserDetails(user))));
        //then
        MvcResult result = actions.andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        List<EmotionSimpleDto> list = mapper.readValue(content, mapper.getTypeFactory().constructCollectionType(List.class, EmotionSimpleDto.class));
        Assertions.assertThat(list).extracting("emotionId").containsExactly(emotionId);
    }
}