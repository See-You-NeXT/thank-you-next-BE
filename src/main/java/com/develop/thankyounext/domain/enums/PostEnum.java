package com.develop.thankyounext.domain.enums;

public enum PostEnum {
    NOTICE(PostRole.NOTICE),
    QUESTION(PostRole.QUESTION),
    FREE(PostRole.FREE);
    private final String dtype;
    PostEnum(String dtype){
        this.dtype = dtype;
    }
    public String getDtype(){
        return this.dtype;
    }
    public static class PostRole{
        public static final String NOTICE = "ROLE_NOTICE";
        public static final String QUESTION = "QUESTION";
        public static final String FREE = "FREE";
    }
}
