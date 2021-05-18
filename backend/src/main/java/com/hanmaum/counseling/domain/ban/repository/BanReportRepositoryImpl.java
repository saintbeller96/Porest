package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.account.entity.QUser;
import com.hanmaum.counseling.domain.account.entity.User;
import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import com.hanmaum.counseling.domain.ban.entity.BanReport;
import com.hanmaum.counseling.domain.ban.entity.BanReportStatus;
import com.hanmaum.counseling.domain.ban.entity.QBanReport;
import com.hanmaum.counseling.domain.post.entity.Counsel;
import com.hanmaum.counseling.domain.post.entity.QCounsel;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.hanmaum.counseling.domain.account.entity.QUser.user;
import static com.hanmaum.counseling.domain.ban.entity.QBanReport.banReport;
import static com.hanmaum.counseling.domain.post.entity.QCounsel.counsel;

@Repository
@RequiredArgsConstructor
public class BanReportRepositoryImpl implements BanReportRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BanReportDetailDto> findProceedingReport(Pageable pageable) {
        QUser counsellor = new QUser("counsellor");
        List<Tuple> tuples = queryFactory
                .select(banReport, counsel, user, counsellor)
                .from(banReport)
                .join(user).on(banReport.reporterId.eq(user.id))
                .join(counsel).on(banReport.counselId.eq(counsel.id))
                .join(counsellor).on(counsel.counsellorId.eq(counsellor.id))
                .where(banReport.banReportStatus.eq(BanReportStatus.PROCEEDING))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Tuple> countQuery = queryFactory
                .select(banReport, counsel, user, counsellor)
                .from(banReport)
                .join(user).on(banReport.reporterId.eq(user.id))
                .join(counsel).on(banReport.counselId.eq(counsel.id))
                .join(counsellor).on(counsel.counsellorId.eq(counsellor.id))
                .where(banReport.banReportStatus.eq(BanReportStatus.PROCEEDING));

        List<BanReportDetailDto> content = tuples.stream()
                .map(this::mapping)
                .collect(Collectors.toList());
        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount);
    }

    private BanReportDetailDto mapping(Tuple tuple) {
        BanReport banReport = tuple.get(0, BanReport.class);
        Counsel counsel = tuple.get(1, Counsel.class);
        User reporter = tuple.get(2, User.class);
        User counsellor = tuple.get(3, User.class);
        return BanReportDetailDto.builder()
                .reporter(new BanReportDetailDto.UserInfo(reporter))
                .reportedUser(new BanReportDetailDto.UserInfo(counsellor))
                .id(banReport.getId())
                .counselId(counsel.getId())
                .banReason(banReport.getBanReason())
                .reportedAt(banReport.getCreatedAt())
                .build();
    }
}
