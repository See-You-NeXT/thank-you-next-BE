package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.member.command.MemberCommandService;
import com.develop.thankyounext.application.member.query.MemberQueryService;
import com.develop.thankyounext.domain.dto.member.MemberRequest.UpdateMemberDTO;
import com.develop.thankyounext.domain.dto.result.ResultResponse.MemberResultDTO;
import com.develop.thankyounext.global.api_payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.develop.thankyounext.domain.dto.member.MemberResponse.GetMemberDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@Tag(name = "사용자 API", description = "사용자 정보 관련 API 입니다.")
public class MemberController {

//    private final MemberQueryService memberQueryService;
//    private final MemberCommandService memberCommandService;

    @GetMapping("/profile")
    @Operation(
            description = "유저 정보를 조회합니다.",
            summary = "유저 정보 조회 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetMemberDTO> getProfile() {
        GetMemberDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }

    @PatchMapping("/profile")
    @Operation(
            description = "유저 정보를 받아 수정합니다.",
            summary = "유저 정보 수정 API (개발중)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<MemberResultDTO> updateProfile(
            @RequestBody UpdateMemberDTO request
    ) {
        MemberResultDTO resultDTO = null;
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
