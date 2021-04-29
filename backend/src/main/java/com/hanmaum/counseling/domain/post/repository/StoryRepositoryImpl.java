package com.hanmaum.counseling.domain.post.repository;


import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.hanmaum.counseling.domain.post.entity.QStory.story;
import static com.hanmaum.counseling.domain.post.entity.QLetter.letter;

@Repository
@RequiredArgsConstructor
public class StoryRepositoryImpl implements StoryRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final int CANDIDATES  = 6;
    private final int PICK_MAX = 3;

    //랜덤으로 CANDIDATES 명의 사연을 중복없이 뽑기
    public List<SimpleStoryDto> getCandidates(Long userId){
        List<Long> ids = queryFactory
                .select(story.id)
                .from(story)
                .where(story.writerId.ne(userId)
                        .and(story.picked.lt(PICK_MAX)))
                .fetch();

        Set<Long> randomSet = new HashSet<>();
        Random random = new Random();
        while(true){
            int i = random.nextInt(ids.size());
            randomSet.add(ids.get(i));
            if(randomSet.size() == CANDIDATES) break;
        }

        return queryFactory
                .select(Projections.constructor(SimpleStoryDto.class,
                        story.id, story.form.title, story.form.content, story.createdAt))
                .from(story)
                .where(story.id.in(randomSet))
                .fetch();
    }

    @Override
    public Optional<SimpleStoryDto> pickOne(Long storyId) {
        SimpleStoryDto result = queryFactory
                .select(Projections.constructor(SimpleStoryDto.class,
                        story.id, letter.id, story.form.title, story.form.content, story.createdAt))
                .from(story)
                .join(letter.post.story, story)
                .where(story.id.eq(storyId))
                .fetchOne();
        return Optional.ofNullable(result);
    }
}
