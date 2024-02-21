package com.develop.thankyounext.application.component.command.entity.vote_option;

import com.develop.thankyounext.application.component.command.entity.vote.VoteCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VoteOptionCommandServiceImpl implements VoteCommandService {
}
