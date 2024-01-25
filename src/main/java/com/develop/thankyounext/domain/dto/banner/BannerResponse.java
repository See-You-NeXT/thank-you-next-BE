package com.develop.thankyounext.domain.dto.banner;

import com.develop.thankyounext.domain.dto.base.BannerDTO;

import java.util.List;

public class BannerResponse {

    public record GetBannerListDTO(
            List<BannerDTO> bannerDTOList,

            // Paging
            Integer listSize,
            Integer totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {
    }
}

