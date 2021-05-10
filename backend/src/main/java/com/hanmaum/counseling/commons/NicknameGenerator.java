package com.hanmaum.counseling.commons;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NicknameGenerator {
    private static List<String> negative = Arrays.asList(
            "슬픈", "우울한", "화난", "그리운", "뭉클한", "서운한", "외로운",
            "무기력한", "주눅드는", "서글픈", "쓸쓸한", "풀이 죽은", "부끄러운",
            "서투른", "녹초가 된", "기죽은", "전전긍긍하는", "조급한", "침울한",
            "울보", "소심한", "간절한", "길을 잃은");
    private static List<String> positive = Arrays.asList(
            "흐뭇한", "상쾌한", "반가운", "따뜻한", "아늑한", "열정적인", "온화한",
            "다정한", "그리워하는", "자유로운", "든든한", "당당한", "자신감 넘치는 ", "낙관적인",
            "사랑스러운", "대충 좋은 감정인", "투머치토커", "킹갓", "빛이나는", "너만 바라보는");
    private static List<String> nouns = Arrays.asList(
            "대나무", "소나무", "참나무", "떡갈나무", "주목", "자작나무", "편백", "가시나무", "전나무",
            "향나무", "벚나무", "은행나무", "마가목", "느티나무", "오동나무", "목련", "치자나무",
            "회양목", "메타세콰이어", "단풍나무", "라일락");
    private static Random random = new Random();

    public static String generatePositive(){
        int i = random.nextInt(positive.size());
        int j = random.nextInt(nouns.size());

        return String.format("%s %s", positive.get(i), nouns.get(j));
    }

    public static String generateNegative(){
        int i = random.nextInt(negative.size());
        int j = random.nextInt(nouns.size());

        return String.format("%s %s", negative.get(i), nouns.get(j));
    }
}
