package com.develop.thankyounext.application.query.entity.gallery;

import com.develop.thankyounext.domain.dto.gallery.GalleryResponse;
import com.develop.thankyounext.domain.entity.Gallery;
import com.develop.thankyounext.domain.repository.comment.CommentRepository;
import com.develop.thankyounext.domain.repository.gallery.GalleryRepository;
import com.develop.thankyounext.infrastructure.converter.CommentConverter;
import com.develop.thankyounext.infrastructure.converter.GalleryConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
