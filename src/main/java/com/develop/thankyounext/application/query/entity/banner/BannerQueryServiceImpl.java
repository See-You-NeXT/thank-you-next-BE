package com.develop.thankyounext.application.query.entity.banner;

import com.develop.thankyounext.domain.dto.banner.BannerResponse.GetBannerList;
import com.develop.thankyounext.domain.entity.Banner;
import com.develop.thankyounext.domain.repository.banner.BannerRepository;
import com.develop.thankyounext.infrastructure.converter.BannerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BannerQueryServiceImpl implements BannerQueryService {

    private final BannerRepository bannerRepository;

    private final BannerConverter bannerConverter;

    @Override
    public GetBannerList getBannerList() {

        List<Banner> bannerList = bannerRepository.findAll();

        return bannerConverter.toGetBannerList(bannerList.stream()
                .map(bannerConverter::toDto).toList());
    }
}
