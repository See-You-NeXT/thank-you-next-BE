package com.develop.thankyounext.application.module.entity.gallery;

import com.develop.thankyounext.domain.repository.gallery.GalleryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GalleryModuleServiceImpl implements GalleryModuleService{

    private final GalleryRepository galleryRepository;
}
