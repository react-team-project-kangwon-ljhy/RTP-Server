package org.rtpserver.global.jwt.exception;

import org.rtpserver.global.exception.security.RTPSecurityException;
import org.springframework.http.HttpStatus;

public class DuplicateLoginException extends RTPSecurityException {

    public DuplicateLoginException() {
        super(HttpStatus.UNAUTHORIZED, "DUPLICATE_LOGIN", "이미 로그인한 상태입니다.");
    }
}
