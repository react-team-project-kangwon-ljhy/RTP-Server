package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class UnauthenticatedAccessException extends RTPSecurityException {
    public UnauthenticatedAccessException() {
        super(HttpStatus.UNAUTHORIZED, "UNAUTHENTICATED_ACCESS", "인증이 필요합니다.");
    }
}
