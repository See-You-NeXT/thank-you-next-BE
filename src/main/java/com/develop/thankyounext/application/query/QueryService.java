package com.develop.thankyounext.application.query;

import com.develop.thankyounext.application.query.entity.banner.BannerQueryService;
import com.develop.thankyounext.application.query.entity.comment.CommentQueryService;
import com.develop.thankyounext.application.query.entity.content.ContentQuerySerivce;
import com.develop.thankyounext.application.query.entity.gallery.GalleryQueryService;
import com.develop.thankyounext.application.query.entity.member.MemberQueryService;
import com.develop.thankyounext.application.query.entity.post.PostQueryService;
import com.develop.thankyounext.application.query.entity.tag.TagQueryService;
import com.develop.thankyounext.application.query.entity.vote.VoteQueryService;
import com.develop.thankyounext.application.query.entity.vote_option.VoteOptionQueryService;

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
