package com.develop.thankyounext.domain.enums;

public enum SolvedEnum {
    TRUE(Solved.SOLVED),
    FALSE(Solved.NOT_SOLVED);
    private final String isSolved;

    SolvedEnum(String isSolved) {
        this.isSolved = isSolved;
    }

    public String getIsSolved() {
        return this.isSolved;
    }

    public static class Solved {
        public static final String SOLVED = "TRUE";
        public static final String NOT_SOLVED = "FALSE";
    }
}
