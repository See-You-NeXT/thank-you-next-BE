package com.develop.thankyounext.application.query.entity.member;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import org.springframework.data.domain.Pageable;

public interface MemberQueryService {
    GetMember getProfile(AuthenticationDto auth);

    GetPostList getPostsByMember(AuthenticationDto auth, Pageable pageable);
}
