package com.develop.thankyounext.domain.dto.banner;

import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.entity.BannerDto;

import java.util.List;

public class BannerResponse {

    public record GetBannerList(
            List<BannerDto> bannerDtoList,
            PageDto pageDto
    ) {
    }
}

