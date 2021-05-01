package com.hanmaum.counseling.commons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NicknameGeneratorTest {

    @Test
    void test() throws Exception{

        //when
        String pos = NicknameGenerator.generatePositive();
        String neg = NicknameGenerator.generateNegative();
        //then
        System.out.println("nickname = " + pos);
        System.out.println("nickname = " + neg);
    }

}