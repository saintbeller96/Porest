package com.hanmaum.counseling.domain.emotion.repository;

import com.hanmaum.counseling.domain.emotion.dto.EmotionCondition;
import com.hanmaum.counseling.domain.emotion.dto.EmotionSimpleDto;
import com.hanmaum.counseling.domain.emotion.entity.Emotion;
import com.hanmaum.counseling.domain.emotion.entity.QEmotion;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.hanmaum.counseling.domain.emotion.entity.QEmotion.emotion;

@Repository
@RequiredArgsConstructor
public class EmotionRepositoryImpl implements EmotionRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<EmotionSimpleDto> findByCondition(EmotionCondition condition, Long userId) {
        return queryFactory
                .select(Projections.constructor(EmotionSimpleDto.class,
                        emotion.id, emotion.feeling, emotion.createdAt.dayOfMonth()))
                .from(emotion)
                .where(userIdEq(userId),
                        yearEq(condition.getYear()),
                        monthEq(condition.getMonth()))
                .fetch();
    }

    @Override
    public Optional<Emotion> findByDate(LocalDateTime today, Long userId) {
        Emotion emotion = queryFactory
                .selectFrom(QEmotion.emotion)
                .where(userIdEq(userId),
                        yearEq(today.getYear()),
                        monthEq(today.getMonthValue()),
                        dayEq(today.getDayOfMonth()))
                .fetchOne();
        return Optional.ofNullable(emotion);
    }

    private BooleanExpression userIdEq(Long userId) {
        return emotion.userId.eq(userId);
    }
    private BooleanExpression yearEq(int year){
        return emotion.createdAt.year().eq(year);
    }
    private BooleanExpression monthEq(int month){
        return emotion.createdAt.month().eq(month);
    }
    private BooleanExpression dayEq(int day){
        return emotion.createdAt.dayOfMonth().eq(day);
    }
}
