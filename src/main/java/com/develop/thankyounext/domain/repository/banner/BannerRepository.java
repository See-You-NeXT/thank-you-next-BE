package com.develop.thankyounext.domain.repository.banner;

import com.develop.thankyounext.domain.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository extends JpaRepository<Banner, Long>, BannerQueryDSL {
}
