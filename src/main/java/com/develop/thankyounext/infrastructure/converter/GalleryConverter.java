package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;
import com.develop.thankyounext.domain.entity.Gallery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GalleryConverter {

    GalleryConverter INSTANCE = Mappers.getMapper(GalleryConverter.class);

    Gallery toGallery(RegisterGallery registerGallery);

    @Mapping(source = "id", target = "galleryId")
    @Mapping(source = "createdAt", target = "executedAt")
    GalleryResult toGalleryResult(Gallery saveGallery);
}
