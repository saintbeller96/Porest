package com.hanmaum.counseling.domain.emotion.repository;

import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.emotion.entity.Emotion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmotionRepositoryCustom {
    List<EmotionSimpleDto> findByCondition(EmotionCondition condition, Long userId);
    Optional<Emotion> findByDate(LocalDateTime today, Long userId);
}
