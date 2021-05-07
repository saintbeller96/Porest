package com.hanmaum.counseling.domain.emotion.service;

import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionDetailDto;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;

import java.util.List;

public interface EmotionService {
    Long saveEmotion(EmotionDetailDto emotionDto, Long userId);
    EmotionDetailDto getEmotionDetail(Long emotionId, Long userId);
    Long updateEmotion(EmotionDetailDto emotionDto,Long emotionId, Long userId);
    Long deleteEmotion(Long emotionId, Long userId);
    List<EmotionSimpleDto> searchEmotion(EmotionCondition condition, Long userId);
}
