package com.hanmaum.counseling.domain.emotion.repository;

import com.hanmaum.counseling.domain.emotion.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotion, Long>, EmotionRepositoryCustom{

}
