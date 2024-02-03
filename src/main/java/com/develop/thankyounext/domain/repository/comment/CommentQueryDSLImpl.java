package com.develop.thankyounext.domain.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentQueryDSLImpl implements CommentQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
