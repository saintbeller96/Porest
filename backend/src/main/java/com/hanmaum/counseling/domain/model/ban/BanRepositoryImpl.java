package com.hanmaum.counseling.domain.model.ban;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hanmaum.counseling.domain.ban.QBan.ban;

@Repository
@RequiredArgsConstructor
public class BanRepositoryImpl implements BanRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Ban> findByUserId(Long userId) {
        return queryFactory
                .selectFrom(ban)
                .join(ban.report).fetchJoin()
                .where(ban.banUser.id.eq(userId))
                .fetch();
    }
}
