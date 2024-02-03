package com.develop.thankyounext.domain.repository.vote_option;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VoteOptionQueryDSLImpl implements VoteOptionQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
