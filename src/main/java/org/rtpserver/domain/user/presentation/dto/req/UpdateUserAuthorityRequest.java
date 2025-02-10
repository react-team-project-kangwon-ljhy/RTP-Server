package org.rtpserver.domain.user.presentation.dto.req;

public record UpdateUserAuthorityRequest(
        Long userId,
        String authority
) {
}
