package com.develop.thankyounext.global.exception.handler;

import com.develop.thankyounext.global.exception.GeneralException;
import com.develop.thankyounext.global.payload.code.BaseErrorCode;

public class PostHandler extends GeneralException {
    public PostHandler(BaseErrorCode code) {
        super(code);
    }
}
