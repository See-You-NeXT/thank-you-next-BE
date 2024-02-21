package com.develop.thankyounext.application.module.entity.vote_option;

import com.develop.thankyounext.domain.repository.vote_option.VoteOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteOptionModuleServiceImpl implements VoteOptionModuleService{

    private final VoteOptionRepository voteOptionRepository;
}
