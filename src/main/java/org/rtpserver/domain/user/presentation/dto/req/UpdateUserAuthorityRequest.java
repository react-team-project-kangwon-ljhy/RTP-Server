package org.rtpserver.domain.user.presentation.dto.req;

import org.rtpserver.domain.user.domain.value.Authority;

public record UpdateUserAuthorityRequest (
        Long userId,
        Authority authority
){
}
