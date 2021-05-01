package com.hanmaum.counseling.domain.post.repository.story;


import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.hanmaum.counseling.domain.post.entity.QCounsel.counsel;
import static com.hanmaum.counseling.domain.post.entity.QLetter.*;
import static com.hanmaum.counseling.domain.post.entity.QStory.story;

@Repository
@RequiredArgsConstructor
public class StoryRepositoryImpl implements StoryRepositoryCustom{
    private final JPAQueryFactory queryFactory;
    private final int CANDIDATES  = 6;
    private final int PICK_MAX = 3;

    /**
     * 랜덤으로 CANDIDATES 명의 사연을 중복없이 뽑기
     */
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
            if(randomSet.size() == CANDIDATES || randomSet.size() == ids.size()) break;
        }

        return queryFactory
                .select(Projections.constructor(SimpleStoryDto.class,
                        story.id, story.form.title, story.form.content, story.createdAt))
                .from(story)
                .where(story.id.in(randomSet))
                .fetch();
    }

    /**
     * 사연에 속한 상담의 Id를 가져온 후
     * 각각의 상담에 속한 Letter-Reply을 반환
     */
    @Override
    public List<CounselContent> findStoryOfUserById(Long storyId, Long userId) {
//        return queryFactory
//                .select(Projections.constructor(CounselContent.class,
//                        letter.counsel.id, letter.form.title, letter.form.content, letter.createdAt,
//                        reply.form.title, reply.form.content, reply.createdAt
//                ))
//                .from(reply)
//                .innerJoin(reply.letter, letter)
//                .where(letter.counsel.id.in(
//                        JPAExpressions
//                                .select(counsel.id)
//                                .from(counsel)
//                                .innerJoin(counsel.story, story)
//                                .where(story.id.eq(storyId))
//                ))
//                .fetch();
        return null;
    }
}
