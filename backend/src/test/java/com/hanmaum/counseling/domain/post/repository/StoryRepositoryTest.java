package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.TestConfig;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StoryRepositoryTest {

    @Autowired
    StoryRepository storyRepository;

    @Test
    void story_pick_test() throws Exception{
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
        candidates.forEach(System.out::println);
    }

}