package com.develop.thankyounext.domain.dto.gallery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class GalleryRequest {

    public record RegisterGallery(
            @NotBlank
            @Size(max = 50)
            String title
    ) {
    }

    public record UpdateGallery(
            @NotNull
            Long galleryId,
            @NotBlank
            @Size(max = 50)
            String title
    ) {
    }

    public record DeleteGallery(
            @NotNull
            Long galleryId
    ) {
    }
}
