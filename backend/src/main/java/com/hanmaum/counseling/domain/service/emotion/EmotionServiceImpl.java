package com.hanmaum.counseling.domain.service.emotion;

import com.hanmaum.counseling.domain.model.user.User;
import com.hanmaum.counseling.domain.service.user.AccountService;
import com.hanmaum.counseling.api.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.model.emotion.Emotion;
import com.hanmaum.counseling.domain.model.emotion.EmotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmotionServiceImpl implements EmotionService{
    private final EmotionRepository emotionRepository;
    private final AccountService accountService;

    @Override
    public Emotion saveEmotion(int feeling, String content, String imageUrl, Long userId) {
        User user = accountService.getUser(userId);
        validate(user.getId());
        return emotionRepository.save(Emotion.builder()
                .feeling(feeling)
                .user(user)
                .content(content)
                .imageUrl(imageUrl)
                .build());
    }
    //이미 오늘 감정을 기록했으면 예외 던짐
    private void validate(Long userId){
        emotionRepository.findByDate(LocalDateTime.now(), userId)
                .ifPresent(emotion->{throw new IllegalStateException("이미 오늘의 감정을 기록했습니다.");});
    }

    @Override
    public Emotion getEmotion(Long emotionId, Long userId) {
        return getEmotionOfUser(emotionId, userId);
    }

    @Override
    public Long updateEmotion(int feeling, String content, String imageUrl, Long emotionId, Long userId) {
        Emotion emotion = getEmotionOfUser(emotionId, userId);
        emotion.update(feeling, content, imageUrl);
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
                .filter(emotion->emotion.getUser().getId() == userId)
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public List<Emotion> searchEmotion(EmotionCondition condition, Long userId) {
        return emotionRepository.findByCondition(condition, userId);
    }
}
