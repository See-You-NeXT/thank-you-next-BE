package com.develop.thankyounext.domain.repository.gallery;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GalleryQueryDSLImpl implements GalleryQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
