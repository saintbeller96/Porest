package com.hanmaum.counseling.domain.emotion.service;

import com.hanmaum.counseling.domain.emotion.Emotion;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.presentation.emotion.dto.EmotionDetailDto;

import java.util.List;

public interface EmotionService {
    Emotion saveEmotion(int feeling, String content, String imageUrl, Long userId);
    Emotion getEmotion(Long emotionId, Long userId);
    Long updateEmotion(int feeling, String content, String imageUrl, Long emotionId, Long userId);
    Long deleteEmotion(Long emotionId, Long userId);
    List<Emotion> searchEmotion(EmotionCondition condition, Long userId);
}
