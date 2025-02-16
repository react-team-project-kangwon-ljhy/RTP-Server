package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class ExpiredRefreshTokenException extends RTPSecurityException {

    public ExpiredRefreshTokenException() {
        super(HttpStatus.UNAUTHORIZED, "EXPIRED_REFRESH_TOKEN", "재로그인 해야 합니다.");
    }
}
