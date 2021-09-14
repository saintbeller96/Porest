package com.hanmaum.counseling.domain.model.emotion;

import com.hanmaum.counseling.api.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.model.emotion.Emotion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EmotionRepositoryCustom {
    List<Emotion> findByCondition(EmotionCondition condition, Long userId);
    Optional<Emotion> findByDate(LocalDateTime today, Long userId);
}
