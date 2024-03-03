package com.develop.thankyounext.domain.repository.tag;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TagQueryDSLImpl implements TagQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
