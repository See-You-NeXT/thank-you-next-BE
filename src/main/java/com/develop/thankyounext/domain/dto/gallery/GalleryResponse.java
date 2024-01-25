package com.develop.thankyounext.domain.dto.gallery;

import com.develop.thankyounext.domain.dto.base.CommentDTO;
import com.develop.thankyounext.domain.dto.base.ContentDTO;
import com.develop.thankyounext.domain.dto.base.SimpleGalleryDTO;

import java.util.List;

public class GalleryResponse {

    public record GetGalleryList(
            List<SimpleGalleryDTO> simpleGalleryDTOList,

            // Paging
            Integer listSize,
            Integer totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {
    }

    public record GetGallery(
            String title,
            ContentDTO contentDTO,
            List<CommentDTO> commentDTOList
    ) {
    }
}
