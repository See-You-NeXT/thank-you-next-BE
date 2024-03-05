package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.entity.Image;
import com.develop.thankyounext.domain.entity.embedded.GalleryImageList;
import com.develop.thankyounext.domain.entity.embedded.PostImageList;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageConverter {

    ImageConverter INSTANCE = Mappers.getMapper(ImageConverter.class);

    default Image toImage(MultipartFile image, AmazonS3Manger amazonS3Manger, String filePath) {
        return Image.builder()
                .url(amazonS3Manger.uploadFileForS3(
                        amazonS3Manger.generateFilesKeyName(filePath), image))
                .build();
    }

    default PostImageList toPostImageList(List<Image> imageList) {
        return PostImageList.builder()
                .imageList(imageList)
                .build();
    }

    default GalleryImageList toGalleryImageList(List<Image> imageList) {
        return GalleryImageList.builder()
                .imageList(imageList)
                .build();
    }
}
