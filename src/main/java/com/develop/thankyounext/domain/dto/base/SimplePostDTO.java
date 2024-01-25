package com.develop.thankyounext.domain.dto.base;

import com.develop.thankyounext.domain.enums.SolvedEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SimplePostDTO {
    private String author;
    @NotBlank
    @Size(max = 50)
    private String title;
    private SolvedEnum isSolved;
    private LocalDateTime createdAt;
}
