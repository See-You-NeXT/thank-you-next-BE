package com.develop.thankyounext.application.query.entity.gallery;

import com.develop.thankyounext.domain.dto.base.common.PageDto;
import com.develop.thankyounext.domain.dto.base.custom.SimpleGalleryDto;
import com.develop.thankyounext.domain.dto.gallery.GalleryResponse;
import com.develop.thankyounext.domain.entity.Gallery;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.gallery.GalleryRepository;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import com.develop.thankyounext.infrastructure.converter.GalleryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GalleryQueryServiceImpl implements GalleryQueryService {
    private final GalleryRepository galleryRepository;
    private final GalleryConverter galleryConverter;
    private final CommentRepository commentRepository;
    private final CommentConverter commentConverter;

    @Override
    public GalleryResponse.GetGallery getGallery(Long galleryId) {
        Gallery gallery = galleryRepository.findById(galleryId).orElseThrow();
        return galleryConverter.toGetGallery(
                galleryConverter.toGalleryDto(gallery),
                gallery.getCommentList().stream().map(commentConverter::toCommentDto).toList()
        );
    }

    @Override
    public GalleryResponse.GetGalleryList getGalleryList(Pageable pageable) {
        Page<Gallery> findGalleries = galleryRepository.findAll(pageable);

        return createGetGalleryList(findGalleries);
    }

    private GalleryResponse.GetGalleryList createGetGalleryList(Page<Gallery> galleries) {
        List<SimpleGalleryDto> simpleGalleryDtoList = galleries.stream().map(galleryConverter::toSimpleGalleryDto).toList();
        PageDto pageDto = galleryConverter.toPageDto(galleries);

        return galleryConverter.toGetGalleryList(simpleGalleryDtoList, pageDto);
    }

}
