package com.develop.thankyounext.infrastructure.converter;

import com.develop.thankyounext.domain.embedded.ImageUrlList;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageUrlListConverter {

    ImageUrlListConverter INSTANCE = Mappers.getMapper(ImageUrlListConverter.class);

    default ImageUrlList toImageUrlList(List<MultipartFile> fileList, AmazonS3Manger amazonS3Manger, AmazonConfig amazonConfig) {
        return ImageUrlList.builder()
                .urls(fileList.stream()
                        .map(image ->
                                amazonS3Manger.uploadFileForS3(
                                        amazonS3Manger.generateFilesKeyName(amazonConfig.getPostPath()), image)).toList())
                .build();
    }
}
