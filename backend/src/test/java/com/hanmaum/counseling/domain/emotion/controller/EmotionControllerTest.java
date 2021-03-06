package com.hanmaum.counseling.domain.emotion.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanmaum.counseling.domain.model.user.Password;
import com.hanmaum.counseling.domain.model.user.RoleType;
import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.model.user.UserRepository;
import com.hanmaum.counseling.domain.model.emotion.Emotion;
import com.hanmaum.counseling.api.emotion.dto.EmotionDetailDto;
import com.hanmaum.counseling.api.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.service.emotion.EmotionService;
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
import org.springframework.security.crypto.password.PasswordEncoder;
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
    PasswordEncoder encoder;
    @Autowired
    ObjectMapper mapper;

    User user;
    @BeforeEach
    void setUp(){
        user = userRepository.save(User.builder()
                .email("test@test.com")
                .role(RoleType.ROLE_USER)
                .password(new Password("1234"))
                .nickname("nickname").build());
    }

    EmotionDetailDto setUpEmotion(){
        return EmotionDetailDto.builder()
                .content("content")
                .feeling(1)
                .imageUrl("url").build();
    }

    @Test
    @DisplayName("?????? ?????? ?????? ????????? 201")
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
    @DisplayName("?????? ?????? ????????? 2??? ?????? ?????? ?????? 404 ??????")
    void saveDuplicatedEmotion() throws Exception{
        //given
        EmotionDetailDto dto = setUpEmotion();
        emotionService.saveEmotion(dto.getFeeling(), dto.getContent(), dto.getImageUrl(), user.getId());

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
    @DisplayName("Emotion Id??? ?????? ?????? ???????????? ?????? 200")
    void getEmotionDetail() throws Exception{
        //given
        var temp = setUpEmotion();
        Emotion saveEmotion = emotionService.saveEmotion(temp.getFeeling(), temp.getContent(), temp.getImageUrl(), user.getId());

        //when
        ResultActions actions = mockMvc.perform(get("/emotions/" + saveEmotion.getId())
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
    @DisplayName("????????? ???/?????? ?????? ?????? ?????? ???????????? ????????? 200")
    void searchEmotions() throws Exception{
        //given
        EmotionDetailDto dto = setUpEmotion();
        Emotion saveEmotion = emotionService.saveEmotion(dto.getFeeling(), dto.getContent(), dto.getImageUrl(), user.getId());

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("month", String.valueOf(LocalDateTime.now().getMonthValue()));
        param.add("year", String.valueOf(LocalDateTime.now().getYear()));
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
        Assertions.assertThat(list).extracting("emotionId").containsExactly(saveEmotion.getId());
    }

    @Test
    @DisplayName("?????? ????????? ?????? ?????? ?????? ??????, ????????? 401")
    void saveEmotionUnauthorizedUser() throws Exception{
        //given
        String content = mapper.writeValueAsString(setUpEmotion());
        //when
        ResultActions actions = mockMvc.perform(post("/emotions")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        actions.andExpect(status().isUnauthorized());
    }
}