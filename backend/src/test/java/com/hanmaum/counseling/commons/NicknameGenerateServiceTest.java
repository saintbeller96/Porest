package com.hanmaum.counseling.commons;

import org.junit.jupiter.api.Test;


class NicknameGenerateServiceTest {

    @Test
    void test() throws Exception{
        //when
        String pos = NicknameGenerateService.generatePositive();
        String neg = NicknameGenerateService.generateNegative();
        //then
        System.out.println("nickname = " + pos);
        System.out.println("nickname = " + neg);
    }

}