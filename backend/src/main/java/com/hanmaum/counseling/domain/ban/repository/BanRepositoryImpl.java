package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.entity.Ban;
import com.hanmaum.counseling.domain.ban.entity.BanStatus;
import com.hanmaum.counseling.domain.ban.entity.QBan;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.hanmaum.counseling.domain.ban.entity.QBan.ban;
import static com.hanmaum.counseling.domain.ban.entity.QBanReport.banReport;

@Repository
@RequiredArgsConstructor
public class BanRepositoryImpl implements BanRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Ban> findByIdFetch(Long banId) {
        Ban result = queryFactory
                .selectFrom(ban)
                .join(ban.report).fetchJoin()
                .where(ban.id.eq(banId))
                .fetchOne();
        return Optional.ofNullable(result);
    }

    @Override
    public List<Ban> findByUserIdFetch(Long userId) {
        return queryFactory
                .selectFrom(ban)
                .join(ban.report).fetchJoin()
                .where(ban.banUserId.eq(userId), ban.banStatus.eq(BanStatus.BANNED))
                .fetch();
    }

    @Override
    public Boolean existsBannedUser(Long userId) {
        Integer result = queryFactory
                .selectOne()
                .from(ban)
                .where(ban.banUserId.eq(userId), ban.banStatus.eq(BanStatus.BANNED))
                .limit(1)
                .fetchFirst();
        return result != null;
    }
}
