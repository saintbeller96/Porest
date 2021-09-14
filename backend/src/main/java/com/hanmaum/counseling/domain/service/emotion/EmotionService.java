package com.hanmaum.counseling.domain.service.emotion;

import com.hanmaum.counseling.domain.model.emotion.Emotion;
import com.hanmaum.counseling.api.emotion.dto.EmotionCondition;

import java.util.List;

public interface EmotionService {
    Emotion saveEmotion(int feeling, String content, String imageUrl, Long userId);
    Emotion getEmotion(Long emotionId, Long userId);
    Long updateEmotion(int feeling, String content, String imageUrl, Long emotionId, Long userId);
    Long deleteEmotion(Long emotionId, Long userId);
    List<Emotion> searchEmotion(EmotionCondition condition, Long userId);
}
