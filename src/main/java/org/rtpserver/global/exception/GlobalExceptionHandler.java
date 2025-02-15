package org.rtpserver.global.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.rtpserver.global.log.LogUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RTPException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(RTPException exception) {
        LogUtils.warn(exception);

        ErrorResponse response = ErrorResponse.from(exception);

        return ResponseEntity
                .status(exception.getStatus())
                .body(response);
    }

    @ExceptionHandler(RTPSecurityException.class)
    public ResponseEntity<ErrorResponse> handleApplicationException(RTPSecurityException exception) {
        LogUtils.warn(exception);

        int httpStatus = exception.getStatus().value();
        String errorCode = exception.getErrorCode();
        String message = exception.getMessage();
        ErrorResponse response = ErrorResponse.from(httpStatus, errorCode, message);

        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> handleDefineException(MethodArgumentTypeMismatchException exception) {
        LogUtils.warn(exception);

        return ResponseEntity.status(400)
                .body(ErrorResponse.from(400, "TYPE_MISMATCH", "파라미터 타입이 일치하지 않습니다."));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorResponse> handleDefineException(IllegalArgumentException exception) {
        LogUtils.warn(exception);

        return ResponseEntity.status(400)
                .body(ErrorResponse.from(400, "INVALID_ARGUMENT", "잘못된 값이 들어왔습니다."));
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> handleDefineException(NullPointerException exception) {
        LogUtils.warn(exception);

        return ResponseEntity.status(400)
                .body(ErrorResponse.from(400, "NULL_VALUE", "필수 값이 누락되었습니다."));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleDefineException(RuntimeException exception) {
        LogUtils.error(exception);

        return ResponseEntity.status(500)
                .body(ErrorResponse.from(500, "SERVER_UNKNOWN","서버에서 알 수 없는 에러가 발생했습니다."));
    }
}
