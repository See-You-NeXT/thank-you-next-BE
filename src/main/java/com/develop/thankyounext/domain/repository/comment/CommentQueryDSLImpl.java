package com.develop.thankyounext.domain.repository.comment;

import com.develop.thankyounext.domain.entity.Post;
import com.develop.thankyounext.domain.entity.QComment;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

@RequiredArgsConstructor
public class CommentQueryDSLImpl implements CommentQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Post> findPostsByMemberCommented(Long memberId, Pageable pageable) {
        QComment comment = QComment.comment;

        List<Post> contents = jpaQueryFactory
                .select(comment.post)
                .from(comment)
                .where(comment.member.id.eq(memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = createCountQuery(comment.member.id.eq(memberId), comment);

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private JPAQuery<Long> createCountQuery(BooleanExpression condition, QComment comment) {
        return jpaQueryFactory
                .select(comment.post.count())
                .from(comment)
                .where(condition);
    }
}
