package com.develop.thankyounext.domain.repository.banner;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BannerQueryDSLImpl implements BannerQueryDSL{

    private final JPAQueryFactory jpaQueryFactory;
}
