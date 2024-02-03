package com.develop.thankyounext.domain.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostQueryDSLImpl implements PostQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
