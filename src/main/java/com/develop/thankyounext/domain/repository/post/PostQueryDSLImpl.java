package com.develop.thankyounext.domain.repository.post;

import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.entity.QPost;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@RequiredArgsConstructor
public class PostQueryDSLImpl implements PostQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Post> findAllByMemberId(Long memberId, Pageable pageable) {
        QPost post = QPost.post;

        List<Post> contents = jpaQueryFactory
                .selectFrom(post)
                .where(post.member.id.eq(memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = createCountQuery(post.member.id.eq(memberId), post);

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private JPAQuery<Long> createCountQuery(BooleanExpression condition, QPost post) {
        return jpaQueryFactory
                .select(post.count())
                .from(post)
                .where(condition);
    }
}
