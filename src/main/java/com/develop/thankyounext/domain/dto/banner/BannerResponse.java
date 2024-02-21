package com.develop.thankyounext.domain.dto.banner;

import com.develop.thankyounext.domain.dto.base.BannerDTO;
import com.develop.thankyounext.domain.dto.base.PageDTO;

import java.util.List;

public class BannerResponse {

    public record GetBannerListDTO(
            List<BannerDTO> bannerDTOList,
            // Paging
            PageDTO pageDTO
    ) {
    }
}

