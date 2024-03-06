package com.develop.thankyounext.domain.repository.image;

import com.develop.thankyounext.domain.entity.Image;
import com.develop.thankyounext.domain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ImageQueryDSL {
    Long deleteAllByPostId(Long postId);
    List<Image> findAllByGalleryId(Long galleryId);
}
