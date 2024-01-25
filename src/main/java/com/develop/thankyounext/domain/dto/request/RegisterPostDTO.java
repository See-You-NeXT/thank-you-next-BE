package com.develop.thankyounext.domain.dto.request;

import com.develop.thankyounext.domain.dto.base.TagDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class RegisterPostDTO {
    @NotNull
    private String dType;
    @NotBlank
    @Size(max = 50)
    private String title;
    @NotBlank
    @Size(max = 2000)
    private String content;
    private List<MultipartFile> images;
    private List<TagDTO> tagList;
}
