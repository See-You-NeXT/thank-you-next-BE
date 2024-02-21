package com.develop.thankyounext.application.module.entity.vote;

import com.develop.thankyounext.domain.repository.vote.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteModuleServiceImpl implements VoteModuleService{

    private final VoteRepository voteRepository;
}
