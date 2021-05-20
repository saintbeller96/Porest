package com.hanmaum.counseling.commons;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NicknameGenerator {
    private static List<String> negatives = Arrays.asList(
            "슬픈", "우울한", "화난", "그리운", "뭉클한", "서운한", "외로운",
            "무기력한", "주눅든", "서글픈", "쓸쓸한", "풀이 죽은", "부끄러운",
            "서투른", "녹초가 된", "기죽은", "전전긍긍하는", "조급한", "침울한",
            "울보", "소심한", "간절한", "길을 잃은", "빛을 잃은");
    private static List<String> positives = Arrays.asList(
            "흐뭇한", "푸근한", "반가운", "따뜻한", "아늑한", "열정적인", "온화한",
            "다정한", "그리워하는", "자유로운", "든든한", "당당한", "자신감있는", "낙관적인",
            "사랑스러운", "투머치토커", "배려깊은", "빛이나는", "유쾌한");
    private static List<String> nouns = Arrays.asList(
            "길잡이별", "꼬리별", "까막별", "떠돌이별", "닻별", "붉은별", "푸른별",
            "샛별", "작은곰별", "잔별", "여우별", "새벽별", "붙박이별", "초신성");
    private static Random random = new Random();

    public static String generatePositive(){
        int i = random.nextInt(positives.size());
        int j = random.nextInt(nouns.size());
        return String.format("%s %s", positives.get(i), nouns.get(j));
    }

    public static String generateNegative(){
        int i = random.nextInt(negatives.size());
        int j = random.nextInt(nouns.size());
        return String.format("%s %s", negatives.get(i), nouns.get(j));
    }
}
