package com.develop.thankyounext.application.module.entity.banner;

import com.develop.thankyounext.domain.repository.banner.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerModuleServiceImpl implements BannerModuleService{

    private final BannerRepository bannerRepository;
}
