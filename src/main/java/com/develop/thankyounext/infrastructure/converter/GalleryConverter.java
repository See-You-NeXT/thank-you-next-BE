package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimpleGalleryDto;
import com.develop.thankyounext.domain.dto.base.entity.CommentDto;
import com.develop.thankyounext.domain.dto.base.entity.GalleryDto;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.gallery.GalleryResponse;
import com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;
import com.develop.thankyounext.domain.entity.Gallery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GalleryConverter {

    GalleryConverter INSTANCE = Mappers.getMapper(GalleryConverter.class);


    Gallery toGallery(RegisterGallery registerGallery);

    @Mapping(source = "imageList", target = "imageUrl")
    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    SimpleGalleryDto toSimpleGalleryDto(Gallery gallery);

    @Mapping(source = "id", target = "galleryId")
    @Mapping(source = "createdAt", target = "executedAt")
    GalleryResult toGalleryResult(Gallery saveGallery);

    GalleryResponse.GetGallery toGetGallery(GalleryDto galleryDto, List<CommentDto> commentDtoList);

    @Mapping(source = "imageList", target = "imageUrlList")
    @Mapping(source = "createdAt", target = "auditingDto.createdAt")
    @Mapping(source = "createdBy", target = "auditingDto.createdBy")
    @Mapping(source = "modifiedAt", target = "auditingDto.modifiedAt")
    GalleryDto toGalleryDto(Gallery gallery);


    default PageDto toPageDto(Page<Gallery> galleries) {
        return PageDto.builder()
                .listSize(galleries.getSize())
                .totalElements(galleries.getTotalElements())
                .isFirst(!galleries.hasPrevious())
                .isLast(!galleries.hasNext())
                .build();
    }

    ;

    GalleryResponse.GetGalleryList toGetGalleryList(List<SimpleGalleryDto> simpleGalleryDtoList, PageDto pageDto);
}
