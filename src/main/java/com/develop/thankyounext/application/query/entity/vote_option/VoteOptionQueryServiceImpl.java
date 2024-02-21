package com.develop.thankyounext.application.query.entity.vote_option;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VoteOptionQueryServiceImpl implements VoteOptionQueryService{
}
