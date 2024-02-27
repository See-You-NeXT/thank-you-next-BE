package com.develop.thankyounext.application.command.entity.comment;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.comment.CommentRequest;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.DeleteComment;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.RegisterComment;
import com.develop.thankyounext.domain.dto.comment.CommentRequest.UpdateComment;
import com.develop.thankyounext.domain.dto.result.ResultResponse.CommentResult;

public interface CommentCommandService {
    CommentResult registerComment(AuthenticationDto auth, Long postId, RegisterComment request);

    CommentResult updateComment(AuthenticationDto auth, Long postId, UpdateComment request);

    CommentResult deleteComment(AuthenticationDto auth, Long postId, DeleteComment request);
}
