package com.develop.thankyounext.domain.repository.vote_option;

import com.develop.thankyounext.domain.entity.VoteOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteOptionRepository extends JpaRepository<VoteOption, Long>, VoteOptionQueryDSL {
}
