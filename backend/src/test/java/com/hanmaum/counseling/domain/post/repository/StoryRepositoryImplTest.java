package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.TestConfig;
import com.hanmaum.counseling.domain.account.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StoryRepositoryImplTest {
    @Autowired
    EntityManager em;

    @Autowired
    StoryRepository storyRepository;

    @BeforeEach
    void init(){
        User user1 = new User();

        User user2 = new User();
    }

    @Test
    void test() throws Exception{
        //given

        //when

        //then
    }
}