package com.hanmaum.counseling.domain.post.repository;

import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.QLetter;
import com.hanmaum.counseling.domain.post.entity.QStory;
import com.hanmaum.counseling.domain.post.entity.StoryStatus;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hanmaum.counseling.domain.post.entity.QLetter.*;
import static com.hanmaum.counseling.domain.post.entity.QStory.*;

@Repository
@RequiredArgsConstructor
public class StoryRepositoryImpl implements StoryRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<SimpleStoryDto> pickCandidates(Long userId) {
        return queryFactory
                .select(Projections.constructor(
                        SimpleStoryDto.class,
                        story.id, letter.id, letter.title, letter.content, letter.createdAt
                ))
                .from(story)
                .join(story, letter.story)
                .where(letter.writerId.ne(userId)
                    .and(story.status.eq(StoryStatus.READY)))
                .limit(CANDIDATES)
                .fetch();
    }
}
