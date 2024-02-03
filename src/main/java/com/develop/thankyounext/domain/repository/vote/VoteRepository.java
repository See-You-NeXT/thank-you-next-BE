package com.develop.thankyounext.domain.repository.vote;

import com.develop.thankyounext.domain.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long>, VoteQueryDSL {
}
