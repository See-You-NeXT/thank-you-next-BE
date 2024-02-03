package com.develop.thankyounext.domain.repository.vote;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VoteQueryDSLImpl implements VoteQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
