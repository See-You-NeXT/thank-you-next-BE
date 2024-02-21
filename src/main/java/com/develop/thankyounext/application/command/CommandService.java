package com.develop.thankyounext.application.command;

import com.develop.thankyounext.application.command.entity.banner.BannerCommandService;
import com.develop.thankyounext.application.command.entity.content.ContentCommandService;
import com.develop.thankyounext.application.command.entity.gallery.GalleryCommandService;
import com.develop.thankyounext.application.command.entity.post.PostCommandService;
import com.develop.thankyounext.application.command.entity.tag.TagCommandService;
import com.develop.thankyounext.application.command.entity.vote.VoteCommandService;
import com.develop.thankyounext.application.command.entity.comment.CommentCommandService;
import com.develop.thankyounext.application.command.entity.member.MemberCommandService;
import com.develop.thankyounext.application.command.entity.vote_option.VoteOptionCommandService;

public interface CommandService extends
        BannerCommandService,
        CommentCommandService,
        ContentCommandService,
        GalleryCommandService,
        MemberCommandService,
        PostCommandService,
        TagCommandService,
        VoteCommandService,
        VoteOptionCommandService {
}
