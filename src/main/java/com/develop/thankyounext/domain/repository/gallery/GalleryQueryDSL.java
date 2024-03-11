package com.develop.thankyounext.domain.repository.gallery;

import com.develop.thankyounext.domain.entity.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GalleryQueryDSL {
    Page<Gallery> findAll(Pageable pageable);

}
