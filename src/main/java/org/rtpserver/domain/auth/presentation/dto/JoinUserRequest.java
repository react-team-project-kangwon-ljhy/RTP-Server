package org.rtpserver.domain.auth.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.rtpserver.domain.user.domain.value.Authority;

public record JoinUserRequest(
        String username,
        String password,
        String description
) {}
