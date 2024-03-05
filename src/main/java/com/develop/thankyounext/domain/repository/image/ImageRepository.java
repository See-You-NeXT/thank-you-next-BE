package com.develop.thankyounext.domain.repository.image;

import com.develop.thankyounext.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long>, ImageQueryDSL {
}
