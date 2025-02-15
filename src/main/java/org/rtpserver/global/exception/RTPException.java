package org.rtpserver.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class RTPException extends RuntimeException {
    private final HttpStatus status;
    private final String errorCode;

    public RTPException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}
