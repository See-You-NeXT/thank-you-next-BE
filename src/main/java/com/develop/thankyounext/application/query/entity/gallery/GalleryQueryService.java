package com.develop.thankyounext.application.query.entity.gallery;

import com.develop.thankyounext.domain.dto.gallery.GalleryResponse;

public interface GalleryQueryService {
    GalleryResponse.GetGallery getGallery(Long galleryId);
}
