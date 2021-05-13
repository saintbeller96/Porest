package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.entity.Ban;
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
        Ban ban = queryFactory
                .selectFrom(QBan.ban)
                .join(banReport).fetchJoin()
                .where(QBan.ban.id.eq(banId))
                .fetchOne();
        return Optional.ofNullable(ban);
    }

    @Override
    public List<Ban> findByUserIdFetch(Long userId) {
        return queryFactory
                .selectFrom(ban)
                .join(banReport).fetchJoin()
                .where(ban.banUserId.eq(userId))
                .fetch();
    }
}
