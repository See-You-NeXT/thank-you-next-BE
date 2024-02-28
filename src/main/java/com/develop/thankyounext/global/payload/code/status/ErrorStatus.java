package com.develop.thankyounext.global.payload.code.status;

import com.develop.thankyounext.global.payload.code.BaseErrorCode;
import com.develop.thankyounext.global.payload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
    _NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON404", "찾을 수 없습니다."),

    // Member
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "해당 사용자를 찾을 수 없습니다."),
    MEMBER_UPDATE_PASSWORD_NOT_EQUAL_BAD_REQUEST(HttpStatus.BAD_REQUEST, "MEMBER4001", "비밀번호와 비밀번호 확인이 일치하지 않습니다."),

    // Comment
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT404", "해당 댓글을 찾을 수 없습니다."),
    COMMENT_NOT_AUTHOR_FORBIDDEN(HttpStatus.FORBIDDEN, "COMMENT4031", "해당 댓글의 작성자가 아닙니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .isSuccess(false)
                .message(message)
                .code(code)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .isSuccess(false)
                .message(message)
                .code(code)
                .httpStatus(httpStatus)
                .build();
    }
}
