package com.hanmaum.counseling.domain.ban.repository;

import com.hanmaum.counseling.domain.ban.dto.BanReportDetailDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BanReportRepositoryImpl implements BanReportRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<BanReportDetailDto> findProceedingReport(Pageable pageable) {
        
        return null;
    }
}
