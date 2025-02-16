package org.rtpserver.global.jwt.dto;

public record LoginRequest (
        String userName,
        String password
){
}
