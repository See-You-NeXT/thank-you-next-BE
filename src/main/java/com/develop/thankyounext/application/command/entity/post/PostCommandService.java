package com.develop.thankyounext.application.command.entity.post;

import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostRequest.DeletePost;
import com.develop.thankyounext.domain.dto.post.PostRequest.RegisterPost;
import com.develop.thankyounext.domain.dto.post.PostRequest.UpdatePost;
import com.develop.thankyounext.domain.dto.result.ResultResponse.PostResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostCommandService {
    PostResult registerPost(AuthenticationDto auth, RegisterPost request, List<MultipartFile> fileList);

    PostResult updatePost(AuthenticationDto auth, UpdatePost request, List<MultipartFile> fileList);

    PostResult deletePost(AuthenticationDto auth, DeletePost request);
}
