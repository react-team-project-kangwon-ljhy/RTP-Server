package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class ExpiredTokenException extends RTPSecurityException {

    public ExpiredTokenException() {
        super(HttpStatus.UNAUTHORIZED, "EXPIRED_TOKEN", "만료된 토큰입니다.");
    }
}
