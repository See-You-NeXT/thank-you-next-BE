package com.develop.thankyounext.domain.repository.gallery;

import com.develop.thankyounext.domain.entity.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long>, GalleryQueryDSL {

}
