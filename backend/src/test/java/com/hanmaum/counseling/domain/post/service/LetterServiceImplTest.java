package com.hanmaum.counseling.domain.post.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class LetterServiceImplTest {
    @Autowired
    LetterService letterService;

    @BeforeEach
    void setUp(){

    }

    @Test
    void test() throws Exception{
        //given

        //when

        //then
    }
}