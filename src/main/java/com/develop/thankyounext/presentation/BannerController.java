package com.develop.thankyounext.presentation;

import com.develop.thankyounext.application.query.entity.banner.BannerQueryService;
import com.develop.thankyounext.global.payload.ApiResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.develop.thankyounext.domain.dto.banner.BannerResponse.GetBannerList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/banner")
@Tag(name = "배너 API", description = "배너 관련 API 입니다.")
public class BannerController {

    private final BannerQueryService bannerQueryService;

    @GetMapping("/banner")
    @Operation(
            description = "메인 페이지의 배너를 조회합니다.",
            summary = "배너 조회 API"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "COMMON200", description = "성공입니다.")
    })
    public ApiResponseDTO<GetBannerList> getBanner() {
        GetBannerList resultDTO = bannerQueryService.getBannerList();
        return ApiResponseDTO.onSuccess(resultDTO);
    }
}
