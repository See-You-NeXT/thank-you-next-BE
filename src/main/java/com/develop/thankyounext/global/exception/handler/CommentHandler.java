package com.develop.thankyounext.global.exception.handler;

import com.develop.thankyounext.global.exception.GeneralException;
import com.develop.thankyounext.global.payload.code.BaseErrorCode;

public class CommentHandler extends GeneralException {
    public CommentHandler(BaseErrorCode code) {
        super(code);
    }
}
