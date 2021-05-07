package com.hanmaum.counseling.domain.emotion.service;

import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionDetailDto;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.emotion.entity.Emotion;
import com.hanmaum.counseling.domain.emotion.repository.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmotionServiceImpl implements EmotionService{
    private final EmotionRepository emotionRepository;

    @Override
    public Long saveEmotion(EmotionDetailDto emotionDto, Long userId) {
        Emotion emotion = Emotion.convertedFromDto(emotionDto, userId);
        Emotion save = emotionRepository.save(emotion);
        return save.getId();
    }

    @Override
    public EmotionDetailDto getEmotionDetail(Long emotionId, Long userId) {
        Emotion emotion = getEmotionOfUser(emotionId, userId);
        return EmotionDetailDto.convertedFromEntity(emotion);
    }

    @Override
    public Long updateEmotion(EmotionDetailDto emotionDto, Long emotionId, Long userId) {
        Emotion emotion = getEmotionOfUser(emotionId, userId);
        emotion.update(emotionDto);
        return emotion.getId();
    }

    @Override
    public Long deleteEmotion(Long emotionId, Long userId) {
        Emotion emotion = getEmotionOfUser(emotionId, userId);
        emotionRepository.delete(emotion);
        return emotionId;
    }

    private Emotion getEmotionOfUser(Long emotionId, Long userId){
        return emotionRepository.findById(emotionId)
                .filter(emotion->emotion.getUserId() == userId)
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<EmotionSimpleDto> searchEmotion(EmotionCondition condition, Long userId) {
        return emotionRepository.findByCondition(condition, userId);
    }
}
