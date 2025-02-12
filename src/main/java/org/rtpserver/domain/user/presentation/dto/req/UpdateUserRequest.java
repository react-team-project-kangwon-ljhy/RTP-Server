package org.rtpserver.domain.user.presentation.dto.req;

import org.rtpserver.domain.user.domain.value.Authority;

public record UpdateUserRequest(
        String userName,
        String password,
        String userDescription,
        Authority authority
) {
}
