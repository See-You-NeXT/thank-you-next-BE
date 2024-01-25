package com.develop.thankyounext.domain.dto.gallery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public class GalleryRequest {
    public record RegisterGalleryDTO(
            @NotBlank
            @Size(max = 50)
            String title
    ) {
    }
    public record DeleteGalleryDTO(
            @NotNull
            Long galleryId
    ) {
    }
}
