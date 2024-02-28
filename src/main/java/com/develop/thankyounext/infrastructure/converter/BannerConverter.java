package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.banner.BannerResponse.GetBannerList;
import com.develop.thankyounext.domain.dto.base.entity.BannerDto;
import com.develop.thankyounext.domain.entity.Banner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BannerConverter {

    BannerConverter INSTANCE = Mappers.getMapper(BannerConverter.class);

    @Mapping(source = "banner.id", target = "id")
    @Mapping(source = "banner.title", target = "title")
    @Mapping(source = "banner.description", target = "description")
    @Mapping(source = "banner.linkUrl", target = "linkUrl")
    @Mapping(source = "banner", target = "auditingDto")
    BannerDto toDto(Banner banner);

    default GetBannerList toGetBannerList(List<BannerDto> bannerDtoList){
        return GetBannerList.builder()
                .bannerDtoList(bannerDtoList)
                .build();
    }
}
