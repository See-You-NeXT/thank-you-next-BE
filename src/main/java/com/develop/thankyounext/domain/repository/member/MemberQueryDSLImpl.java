package com.develop.thankyounext.domain.repository.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberQueryDSLImpl implements MemberQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
