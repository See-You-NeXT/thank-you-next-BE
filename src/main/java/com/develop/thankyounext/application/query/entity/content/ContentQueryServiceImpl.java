package com.develop.thankyounext.application.query.entity.content;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ContentQueryServiceImpl implements ContentQuerySerivce {
}
