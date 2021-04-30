package com.hanmaum.counseling.domain.post.service.story;

import com.hanmaum.counseling.domain.post.dto.DetailStoryDto;
import com.hanmaum.counseling.domain.post.dto.FormDto;
import com.hanmaum.counseling.domain.post.dto.SimpleCounselDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.service.LetterService;
import com.hanmaum.counseling.domain.post.service.ReplyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
class StoryServiceImplTest {
    @Autowired
    StoryService storyService;

    @Autowired
    LetterService letterService;

    @Autowired
    ReplyService replyService;

    @Test
    void get_story_test() throws Exception{
        //given
        //1.사연 등록
        Long fromId = 1L;
        Long storyId = storyService.putStory(createSimpleStory("title", "content"), fromId);

        //2. 사연 뽑기
        Long toId = 2L;
        SimpleCounselDto simplePostDto = storyService.pickStory(storyId, toId);
        Long letterId = simplePostDto.getLetterId();
        Long postId = simplePostDto.getPostId();

        //3. 답장
        Long replyId = replyService.writeReply(createFormDto("reply title", "reply content"), letterId, toId);

        //4. 편지-답장 주고 받기
        for(int i = 1; i<8; i++){
            FormDto tempLetter = new FormDto("letter title " + i, "letter content " + i, null);
            FormDto tempReply = new FormDto("reply title " + i, "reply content " + i, null);
            Long id = letterService.writeLetter(tempLetter, postId, fromId);
            replyService.writeReply(tempReply, id, toId);
        }

        //when
        List<DetailStoryDto> result = storyService.getStory(storyId, fromId);
        //then
        for(DetailStoryDto dto : result){
            dto.getDetail().forEach(System.out::println);
        }
        Assertions.assertThat(result).extracting("postId").containsExactly(postId);
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

    FormDto createFormDto(String title, String content){
        return new FormDto(title, content, null);
    }
    SimpleStoryDto createSimpleStory(String title, String content){
        return SimpleStoryDto.builder()
                .title(title)
                .content(content)
                .build();
    }

}