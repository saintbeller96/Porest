package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.counsel.Counsel;
import com.hanmaum.counseling.domain.post.letter.Letter;
import com.hanmaum.counseling.domain.post.story.Story;
import com.hanmaum.counseling.presentation.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.story.repository.StoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
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
                    .title("title " + i)
                    .content("content " + i)
                    .build();
            em.persist(story);
        }
        //when
        List<SimpleStoryDto> candidates = storyRepository.getCandidates(10L);
        //then
        Assertions.assertThat(candidates.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("userId에 따라 해당 유저가 등록한 모든 Story 반환")
    void findStoryByWriterIdTest() throws Exception{
        //given
        Long writerId = 1L;
        Story story = Story.builder()
                .writerId(writerId)
                .title("title ")
                .content("content ")
                .build();
        em.persist(story);

        setDBCondition(story);
        em.flush();
        em.clear();
        //when
        List<Story> result = storyRepository.findByWriterId(writerId);
        //then
        for(var s : result){
            for(var c : s.getCounsels()){
                System.out.println(c.getLetters().size());
            }
        }
    }

    void setDBCondition(Story story){
        for(int k = 1; k<3; k++){
            Long counsellorId = 100000L + k;
            Counsel counsel = Counsel.createConnectedCounsel(story, counsellorId);
            story.addCounsel(counsel);
            em.persist(counsel);

            Letter parentLetter =  Letter.builder()
                    .writerId(story.getId())
                    .content(k + " letter content 1")
                    .title(k + " letter title 1")
                    .build();
            counsel.addLetter(parentLetter);
            for(int i = 2; i<6; i++){
                Long writerId = story.getWriterId();
                if(i%2 == 0){
                    writerId = counsellorId;
                }
                Letter letter = Letter.builder()
                        .writerId(writerId)
                        .content(k + " letter content " + i)
                        .title(k + " letter title " + i)
                        .parentLetter(parentLetter)
                        .build();
                em.persist(letter);
                counsel.addLetter(letter);
                parentLetter = letter;
            }
        }
    }
}