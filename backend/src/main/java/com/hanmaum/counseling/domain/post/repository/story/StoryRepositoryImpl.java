package com.hanmaum.counseling.domain.post.repository.story;


import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.hanmaum.counseling.domain.post.dto.SimpleStoryDto;
import com.hanmaum.counseling.domain.post.entity.QLetter;
import com.hanmaum.counseling.domain.post.entity.QPosts;
import com.hanmaum.counseling.domain.post.entity.QReply;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.hanmaum.counseling.domain.post.entity.QLetter.*;
import static com.hanmaum.counseling.domain.post.entity.QPosts.posts;
import static com.hanmaum.counseling.domain.post.entity.QReply.reply;
import static com.hanmaum.counseling.domain.post.entity.QStory.story;

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

    /**
     * 사연에 속한 Post의 Id를 가져온 후
     * 각각의 Post에 속한 Letter-Reply을 반환
     *
     * @param storyId
     * @param userId
     * @return
     */
    @Override
    public List<PostContent> getStory(Long storyId, Long userId) {
//        //ToDo: SubQuery로 바꾸기
//        List<Long> ids = queryFactory
//                .select(posts.id)
//                .from(posts)
//                .innerJoin(posts.story, story)
//                .where(story.id.eq(storyId))
//                .fetch();

        List<PostContent> result = queryFactory
                .select(Projections.constructor(PostContent.class,
                        letter.post.id, letter.form.title, letter.form.content, letter.createdAt,
                        reply.form.title, reply.form.content, reply.createdAt
                ))
                .from(reply)
                .innerJoin(reply.letter, letter)
                .where(letter.post.id.in(
                        JPAExpressions
                                .select(posts.id)
                                .from(posts)
                                .innerJoin(posts.story, story)
                                .where(story.id.eq(storyId))
                ))
                .fetch();
        return result;
    }
}
