package com.develop.thankyounext.domain.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryDSLImpl implements MemberQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
