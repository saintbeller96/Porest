package com.hanmaum.counseling.domain.model.emotion;

import com.hanmaum.counseling.api.emotion.dto.EmotionCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.hanmaum.counseling.domain.emotion.QEmotion.emotion;

@Repository
@RequiredArgsConstructor
public class EmotionRepositoryImpl implements EmotionRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Emotion> findByCondition(EmotionCondition condition, Long userId) {
        return queryFactory
                .selectFrom(emotion)
                .where(userIdEq(userId),
                        yearEq(condition.getYear()),
                        monthEq(condition.getMonth()))
                .fetch();
    }

    @Override
    public Optional<Emotion> findByDate(LocalDateTime today, Long userId) {
        Emotion ret = queryFactory
                .selectFrom(emotion)
                .where(userIdEq(userId),
                        yearEq(today.getYear()),
                        monthEq(today.getMonthValue()),
                        dayEq(today.getDayOfMonth()))
                .fetchOne();
        return Optional.ofNullable(ret);
    }

    private BooleanExpression userIdEq(Long userId) {
        return emotion.user.id.eq(userId);
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
