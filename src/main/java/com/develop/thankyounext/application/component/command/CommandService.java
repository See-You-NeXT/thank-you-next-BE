package com.develop.thankyounext.application.component.command;

import com.develop.thankyounext.application.component.command.entity.banner.BannerCommandService;
import com.develop.thankyounext.application.component.command.entity.comment.CommentCommandService;
import com.develop.thankyounext.application.component.command.entity.content.ContentCommandService;
import com.develop.thankyounext.application.component.command.entity.gallery.GalleryCommandService;
import com.develop.thankyounext.application.component.command.entity.member.MemberCommandService;
import com.develop.thankyounext.application.component.command.entity.post.PostCommandService;
import com.develop.thankyounext.application.component.command.entity.tag.TagCommandService;
import com.develop.thankyounext.application.component.command.entity.vote.VoteCommandService;
import com.develop.thankyounext.application.component.command.entity.vote_option.VoteOptionCommandService;

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
