package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends RTPSecurityException {

    public InvalidTokenException() {
        super(HttpStatus.UNAUTHORIZED, "INVALID_TOKEN", "잘못된 토큰입니다.");
    }
}
