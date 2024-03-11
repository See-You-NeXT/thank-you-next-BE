package com.develop.thankyounext.domain.repository.gallery;

import com.develop.thankyounext.domain.entity.Gallery;
import com.develop.thankyounext.domain.entity.QGallery;
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
public class GalleryQueryDSLImpl implements GalleryQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Gallery> findAll(Pageable pageable) {
        QGallery gallery = QGallery.gallery;

        List<Gallery> contents = jpaQueryFactory
                .selectFrom(gallery)
                .offset(pageable.getOffset())
                .limit(pageable.getPageNumber())
                .fetch();

        JPAQuery<Long> countQuery = createCountQuery(gallery);

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchOne);
    }

    private JPAQuery<Long> createCountQuery(QGallery gallery) {
        return jpaQueryFactory
                .select(gallery.count())
                .from(gallery);
    }
}
