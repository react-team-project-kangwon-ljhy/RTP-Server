package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class CustomAccessDeniedException extends RTPSecurityException {
    public CustomAccessDeniedException() {
        super(HttpStatus.FORBIDDEN, "ACCESS_DENIED", "권한이 필요합니다.");
    }
}
