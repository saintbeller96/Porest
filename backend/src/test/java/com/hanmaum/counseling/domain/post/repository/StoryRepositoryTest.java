package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.TestConfig;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.*;
import com.hanmaum.counseling.domain.post.repository.story.PostContent;
import com.hanmaum.counseling.domain.post.repository.story.StoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
@Import(TestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StoryRepositoryTest {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    EntityManager em;

    @Test
    void story_candidates_test() throws Exception{
        //given
        for(long i = 1; i<100; i++){
            Story story = Story.builder()
                    .writerId(i)
                    .title("this is title of" + i)
                    .content("this is content of " + i)
                    .isOpened(false)
                    .build();
            storyRepository.save(story);
        }
        //when
        List<SimpleStoryDto> candidates = storyRepository.getCandidates(10L);
        //then
        Assertions.assertThat(candidates.size()).isEqualTo(6);
    }


    @Test
    void story_get_test() throws Exception{
        //given
        Long userId = 1L;
        Story story = null;
        for(int i = 1; i<=3; i++){
            Story s = Story.builder()
                    .writerId(userId)
                    .title(i + " this is title ")
                    .content(i + " this is content ")
                    .isOpened(false).build();
            story = storyRepository.save(s);
        }

        setDBCondition(story, userId);
        em.flush();
        em.clear();
        //when
        List<PostContent> result = storyRepository.getStory(story.getId(), userId);
        //then
        result.forEach(System.out::println);
        Assertions.assertThat(result.size()).isEqualTo(8);
    }

    void setDBCondition(Story story, Long userId){
        for(int k = 1; k<3; k++){
            Posts post = new Posts(story, userId, PostStatus.CONNECT);
            em.persist(post);

            for(int i = 1; i<5; i++){
                Letter letter = Letter.builder()
                        .writerId(story.getId())
                        .content(k + story.getForm().getContent() + i)
                        .title(k + story.getForm().getTitle() + i)
                        .post(post)
                        .build();
                em.persist(letter);

                Reply reply = Reply.builder()
                        .title(k + "reply title" + i)
                        .content(k + "reply content" + i)
                        .letter(letter)
                        .writerId(2L).build();
                em.persist(reply);
            }
        }
    }
}