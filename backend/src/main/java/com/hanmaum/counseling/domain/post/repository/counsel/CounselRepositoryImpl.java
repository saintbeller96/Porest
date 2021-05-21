package com.hanmaum.counseling.domain.post.repository.counsel;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.QCounsel;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.hanmaum.counseling.domain.post.entity.QCounsel.counsel;
import static com.hanmaum.counseling.domain.post.entity.QLetter.letter;

@Repository
@RequiredArgsConstructor
public class CounselRepositoryImpl implements CounselRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Counsel> findByCounselId(Long counselId) {
        Counsel find = queryFactory
                .select(counsel)
                .from(counsel)
                .leftJoin(counsel.letters).fetchJoin()
                .where(counsel.id.eq(counselId))
                .fetchOne();
        return Optional.ofNullable(find);
    }

    @Override
    public List<Counsel> findByCounsellorId(Long counsellorId) {
        return queryFactory
                .selectFrom(counsel).distinct()
                .join(counsel.story).fetchJoin()
                .leftJoin(counsel.letters).fetchJoin()
                .where(counsel.counsellorId.eq(counsellorId))
                .fetch();
    }

    @Override
    public List<Counsel> findByUserId(Long userId) {
        return queryFactory
                .selectFrom(counsel).distinct()
                .join(counsel.story).fetchJoin()
                .leftJoin(counsel.letters).fetchJoin()
                .where(counsel.story.writerId.eq(userId))
                .fetch();
    }
}
