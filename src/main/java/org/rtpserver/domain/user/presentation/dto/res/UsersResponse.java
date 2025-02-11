package org.rtpserver.domain.user.presentation.dto.res;

import java.util.List;

public record UsersResponse(
        List<UserResponse> usersResponse
) {
}
