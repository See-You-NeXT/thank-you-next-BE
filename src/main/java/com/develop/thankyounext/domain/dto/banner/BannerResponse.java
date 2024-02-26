package com.develop.thankyounext.domain.dto.banner;

import com.develop.thankyounext.domain.dto.base.entity.BannerDto;
import lombok.Builder;

import java.util.List;

public class BannerResponse {

    @Builder
    public record GetBannerList(
            List<BannerDto> bannerDtoList
    ) {
    }
}

