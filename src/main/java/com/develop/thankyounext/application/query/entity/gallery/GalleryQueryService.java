package com.develop.thankyounext.application.query.entity.gallery;

import com.develop.thankyounext.domain.dto.gallery.GalleryResponse;
import org.springframework.data.domain.Pageable;

public interface GalleryQueryService {
    GalleryResponse.GetGallery getGallery(Long galleryId);

    GalleryResponse.GetGalleryList getGalleryList(Pageable pageable);
}
