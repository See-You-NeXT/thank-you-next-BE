package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.command.entity.member.MemberCommandService;
import com.develop.thankyounext.application.query.entity.member.MemberQueryService;
import com.develop.thankyounext.domain.dto.base.common.AuthenticationDto;
import com.develop.thankyounext.domain.dto.post.PostResponse.GetPostList;
import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResult;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static com.develop.thankyounext.domain.dto.member.MemberRequest.UpdateMember;
import static com.develop.thankyounext.domain.dto.member.MemberResponse.GetMember;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "사용자 API", description = "사용자 정보 관련 API 입니다.")
public class MemberController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;

    @GetMapping("/profile")
    @Operation(
            description = "유저 정보를 조회합니다.",
            summary = "유저 정보 조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetMember> getProfile(
            @AuthenticationPrincipal final AuthenticationDto auth
    ) {
        GetMember resultDTO = memberQueryService.getProfile(auth);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/profile")
    @Operation(
            description = "유저 정보를 받아 수정합니다.",
            summary = "유저 정보 수정 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<MemberResult> updateProfile(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @RequestBody final UpdateMember request
    ) {
        MemberResult resultDTO = memberCommandService.updateProfile(auth, request);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @GetMapping("/posts")
    @Operation(
            description = "유저가 작성한 게시글을 조회합니다.",
            summary = "유저 작성 게시글 조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetPostList> getPostsByMember(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PageableDefault Pageable pageable
    ) {
        GetPostList resultDTO = memberQueryService.getPostsByMember(auth, pageable);
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @GetMapping("/comments")
    @Operation(
            description = "유저가 댓글 남긴 게시글을 조회합니다.",
            summary = "유저 댓글 남긴 게시글 조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetPostList> getPostsByMemberCommented(
            @AuthenticationPrincipal final AuthenticationDto auth,
            @PageableDefault Pageable pageable
    ) {
        GetPostList resultDTO = memberQueryService.getPostsByMemberCommented(auth, pageable);
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
