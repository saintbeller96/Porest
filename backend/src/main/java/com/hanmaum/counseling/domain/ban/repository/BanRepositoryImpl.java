package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.Ban;
import com.hanmaum.counseling.domain.ban.BanStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.hanmaum.counseling.domain.ban.entity.QBan.ban;

@Repository
@RequiredArgsConstructor
public class BanRepositoryImpl implements BanRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Ban> findByUserId(Long userId) {
        return queryFactory
                .selectFrom(ban)
                .join(ban.report).fetchJoin()
                .where(ban.banUserId.eq(userId))
                .fetch();
    }
}
