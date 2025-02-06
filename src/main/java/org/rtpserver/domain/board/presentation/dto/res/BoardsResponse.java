package org.rtpserver.domain.board.presentation.dto.res;

import java.util.List;

public record BoardsResponse(
        List<BoardResponse> boardsResponse
) {
}
