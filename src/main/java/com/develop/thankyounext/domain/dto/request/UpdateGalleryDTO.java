package com.develop.thankyounext.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class UpdateGalleryDTO {
    @NotBlank
    @Size(max = 50)
    private String title;
    private List<MultipartFile> contents;
}
