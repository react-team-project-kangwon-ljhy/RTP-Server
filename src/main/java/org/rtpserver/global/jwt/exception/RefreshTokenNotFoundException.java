package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class RefreshTokenNotFoundException extends RTPSecurityException {

    public RefreshTokenNotFoundException() {
        super(HttpStatus.UNAUTHORIZED, "REFRESH_TOKEN_NOT_FOUND", "리프레시 토큰이 존재하지 않습니다.");
    }
}
