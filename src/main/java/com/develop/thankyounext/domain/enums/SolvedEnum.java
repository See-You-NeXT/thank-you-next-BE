package com.develop.thankyounext.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SolvedEnum {

    TRUE(Solved.SOLVED),
    FALSE(Solved.NOT_SOLVED);

    private final String isSolved;

    public static class Solved {
        public static final String SOLVED = "TRUE";
        public static final String NOT_SOLVED = "FALSE";
    }
}
