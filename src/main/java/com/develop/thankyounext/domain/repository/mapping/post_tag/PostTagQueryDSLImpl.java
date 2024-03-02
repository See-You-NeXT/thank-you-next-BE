package com.develop.thankyounext.domain.repository.mapping.post_tag;

import com.develop.thankyounext.domain.entity.mapping.QPostTag;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostTagQueryDSLImpl implements PostTagQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Long deleteAllByPostId(Long postId) {
        QPostTag postTag = QPostTag.postTag;

        return jpaQueryFactory
                .delete(postTag)
                .where(postTag.post.id.eq(postId))
                .execute();
    }
}
