package com.hanmaum.counseling.domain.post.repository.post;

import com.hanmaum.counseling.domain.post.dto.LetterReplyDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hanmaum.counseling.domain.post.entity.QLetter.letter;
import static com.hanmaum.counseling.domain.post.entity.QReply.reply;

@Repository
@RequiredArgsConstructor
public class CounselRepositoryImpl implements CounselRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<LetterReplyDto> getLetterReply(Long postId) {
        return queryFactory
                .select(Projections.constructor(LetterReplyDto.class,
                        letter.form.title, letter.form.content, letter.createdAt,
                        reply.form.title, reply.form.content, reply.createdAt))
                .from(letter)
                .innerJoin(reply.letter, letter)
                .where(letter.post.id.eq(postId))
                .fetch();
    }
}
