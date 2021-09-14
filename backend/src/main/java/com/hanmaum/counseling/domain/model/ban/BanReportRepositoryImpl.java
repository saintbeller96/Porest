package com.hanmaum.counseling.domain.model.ban;

import com.hanmaum.counseling.domain.account.QUser;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.hanmaum.counseling.domain.account.QUser.user;
import static com.hanmaum.counseling.domain.ban.QBanReport.banReport;
import static com.hanmaum.counseling.domain.post.counsel.QCounsel.counsel;

@Repository
@RequiredArgsConstructor
public class BanReportRepositoryImpl implements BanReportRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BanReport> findWaitingReport(Pageable pageable) {
        QUser counsellor = new QUser("counsellor");
        List<BanReport> content = queryFactory
                .selectFrom(banReport)
                .join(user).on(banReport.reporter.id.eq(user.id))
                .join(counsel).on(banReport.counsel.id.eq(counsel.id))
                .join(counsellor).on(counsel.counsel.id.eq(counsellor.id))
                .where(banReport.banReportStatus.eq(BanReportStatus.WAIT))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Tuple> countQuery = queryFactory
                .select(banReport, counsel, user, counsellor)
                .from(banReport)
                .join(user).on(banReport.reporter.id.eq(user.id))
                .join(counsel).on(banReport.counsel.id.eq(counsel.id))
                .join(counsellor).on(counsel.counsellor.id.eq(counsellor.id))
                .where(banReport.banReportStatus.eq(BanReportStatus.WAIT));


        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }
}
