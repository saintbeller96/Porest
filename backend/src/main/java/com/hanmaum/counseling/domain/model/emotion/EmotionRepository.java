package com.hanmaum.counseling.domain.model.emotion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotion, Long>, EmotionRepositoryCustom{

}
