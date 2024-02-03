package com.develop.thankyounext.domain.repository.member;

import com.develop.thankyounext.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberQueryDSL {
}
