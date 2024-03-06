package com.develop.thankyounext.application.command.entity.gallery;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest;
import com.develop.thankyounext.domain.dto.gallery.GalleryRequest.RegisterGallery;
import com.develop.thankyounext.domain.dto.result.ResultResponse.GalleryResult;
import com.develop.thankyounext.domain.entity.Gallery;
import com.develop.thankyounext.domain.entity.Image;
import com.develop.thankyounext.domain.repository.gallery.GalleryRepository;
import com.develop.thankyounext.domain.repository.image.ImageRepository;
import com.develop.thankyounext.global.manager.amazon.s3.AmazonS3Manger;
import com.develop.thankyounext.infrastructure.config.aws.AmazonConfig;
import com.develop.thankyounext.infrastructure.converter.GalleryConverter;
import com.develop.thankyounext.infrastructure.converter.ImageConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class GalleryCommandServiceImpl implements GalleryCommandService {
    private final ImageRepository imageRepository;

    private final GalleryRepository galleryRepository;

    private final GalleryConverter galleryConverter;
    private final ImageConverter imageConverter;

    // Amazon S3 Link
    private final AmazonS3Manger amazonS3Manger;
    private final AmazonConfig amazonConfig;

    @Override
    public GalleryResult registerGallery(AuthenticationDto auth, RegisterGallery request, List<MultipartFile> fileList) {

        Gallery newGallery = galleryConverter.toGallery(request);

        List<Image> imageList = createImages(fileList, newGallery);

        Gallery saveGallery = galleryRepository.save(newGallery);
        imageRepository.saveAll(imageList);

        return galleryConverter.toGalleryResult(saveGallery);
    }

    @Override
    public GalleryResult updateGallery(AuthenticationDto auth, GalleryRequest.UpdateGallery request, List<MultipartFile> fileList) {

        Gallery savedGallery = galleryRepository.findById(request.galleryId()).orElseThrow();

        List<Image> imageList = updateImages(fileList, savedGallery);

        imageRepository.saveAll(imageList);

        return galleryConverter.toGalleryResult(savedGallery);
    }

    @Override
    public GalleryResult deleteGallery(AuthenticationDto auth, GalleryRequest.DeleteGallery request) {
        Gallery savedGallery = galleryRepository.findById(request.galleryId()).orElseThrow();

        List<Image> savedImageList = imageRepository.findAllByGalleryId(savedGallery.getId());

        deleteImageList(savedImageList);

        GalleryResult galleryResult = galleryConverter.toGalleryResult(savedGallery);

        galleryRepository.delete(savedGallery);

        return galleryResult;
    }

    private List<Image> createImages(List<MultipartFile> fileList, Gallery gallery) {
        List<Image> imageList = fileList.stream().map(file -> {
            Image image = imageConverter.toImage(file, amazonS3Manger, amazonConfig.getPostPath());
            image.setGallery(gallery);
            return image;
        }).toList();
        gallery.setImageList(imageConverter.toGalleryImageList(imageList));
        return imageList;
    }

    private List<Image> updateImages(List<MultipartFile> fileList, Gallery gallery) {
        List<Image> savedImageList = imageRepository.findAllByGalleryId(gallery.getId());
        List<Image> imageList = new ArrayList<>();
        List<Image> deleteImageList = new ArrayList<>();
        fileList.forEach(file -> {
            boolean isExist = false;
            Image image = imageConverter.toImage(file, amazonS3Manger, amazonConfig.getPostPath());
            for (Image savedImage : savedImageList) {
                if (savedImage.getUrl().equals(image.getUrl())) isExist = true;
            }
            if (!isExist) imageList.add(image);
            deleteImageList.add(image);
        });
        deleteImageList(deleteImageList);
        gallery.setImageList(imageConverter.toGalleryImageList(imageList));
        return imageList;
    }

    private void deleteImageList(List<Image> deleteImageList) {
        imageRepository.deleteAll(deleteImageList);
    }
}
