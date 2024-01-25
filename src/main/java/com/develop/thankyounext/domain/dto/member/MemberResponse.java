package com.develop.thankyounext.domain.dto.member;

import java.time.LocalDateTime;
import java.util.List;

public class MemberResponse {

    public record GetMemberDTO(
            String name,
            Integer studentId,
            String imageUrl,
            String description,
            List<String> linkList,
            LocalDateTime createdAt
    ) {
    }
}

