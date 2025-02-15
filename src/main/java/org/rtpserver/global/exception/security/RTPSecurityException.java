package org.rtpserver.global.exception.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class RTPSecurityException extends AuthenticationException {
    private final HttpStatus status;
    private final String errorCode;

    public RTPSecurityException(HttpStatus status, String errorCode, String message) {
        super(message);
        this.status = status;
        this.errorCode = errorCode;
    }
}
