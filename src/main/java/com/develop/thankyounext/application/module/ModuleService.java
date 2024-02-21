package com.develop.thankyounext.application.module;

import com.develop.thankyounext.application.module.entity.banner.BannerModuleService;
import com.develop.thankyounext.application.module.entity.comment.CommentModuleService;
import com.develop.thankyounext.application.module.entity.content.ContentModuleService;
import com.develop.thankyounext.application.module.entity.gallery.GalleryModuleService;
import com.develop.thankyounext.application.module.entity.member.MemberModuleService;
import com.develop.thankyounext.application.module.entity.post.PostModuleService;
import com.develop.thankyounext.application.module.entity.tag.TagModuleService;
import com.develop.thankyounext.application.module.entity.vote.VoteModuleService;
import com.develop.thankyounext.application.module.entity.vote_option.VoteOptionModuleService;
import com.develop.thankyounext.application.module.etc.amazon.s3.AmazonS3ModuleService;

public interface ModuleService extends
        BannerModuleService,
        CommentModuleService,
        ContentModuleService,
        GalleryModuleService,
        MemberModuleService,
        PostModuleService,
        TagModuleService,
        VoteModuleService,
        VoteOptionModuleService,

        AmazonS3ModuleService {
}
