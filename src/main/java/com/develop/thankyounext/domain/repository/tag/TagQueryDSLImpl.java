package com.develop.thankyounext.domain.repository.tag;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TagQueryDSLImpl implements TagQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
