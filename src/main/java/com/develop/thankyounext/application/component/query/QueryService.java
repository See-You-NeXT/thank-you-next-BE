package com.develop.thankyounext.application.component.query;

import com.develop.thankyounext.application.component.query.entity.banner.BannerQueryService;
import com.develop.thankyounext.application.component.query.entity.comment.CommentQueryService;
import com.develop.thankyounext.application.component.query.entity.content.ContentQuerySerivce;
import com.develop.thankyounext.application.component.query.entity.gallery.GalleryQueryService;
import com.develop.thankyounext.application.component.query.entity.member.MemberQueryService;
import com.develop.thankyounext.application.component.query.entity.post.PostQueryService;
import com.develop.thankyounext.application.component.query.entity.tag.TagQueryService;
import com.develop.thankyounext.application.component.query.entity.vote.VoteQueryService;
import com.develop.thankyounext.application.component.query.entity.vote_option.VoteOptionQueryService;

public interface QueryService extends
        BannerQueryService,
        CommentQueryService,
        ContentQuerySerivce,
        GalleryQueryService,
        MemberQueryService,
        PostQueryService,
        TagQueryService,
        VoteQueryService,
        VoteOptionQueryService {
}
