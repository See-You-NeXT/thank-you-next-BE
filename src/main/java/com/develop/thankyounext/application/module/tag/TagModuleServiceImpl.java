package com.develop.thankyounext.application.module.tag;

import com.develop.thankyounext.domain.repository.tag.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagModuleServiceImpl implements TagModuleService{

    private final TagRepository tagRepository;
}
