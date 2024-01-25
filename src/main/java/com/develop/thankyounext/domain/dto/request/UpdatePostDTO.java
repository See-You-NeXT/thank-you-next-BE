package com.develop.thankyounext.domain.dto.request;

import com.develop.thankyounext.domain.dto.base.TagDTO;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
public class UpdatePostDTO {
    private String title;
    private String content;
    private List<MultipartFile> images;
    private List<TagDTO> tagList;
}
