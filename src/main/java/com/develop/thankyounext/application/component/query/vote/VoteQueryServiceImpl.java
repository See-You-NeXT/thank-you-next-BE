package com.develop.thankyounext.application.component.query.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VoteQueryServiceImpl implements VoteQueryService{
}
