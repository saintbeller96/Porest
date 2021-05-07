package com.hanmaum.counseling.domain.emotion.repository;

import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;

import java.util.List;

public interface EmotionRepositoryCustom {
    List<EmotionSimpleDto> findByCondition(EmotionCondition condition, Long userId);
}
