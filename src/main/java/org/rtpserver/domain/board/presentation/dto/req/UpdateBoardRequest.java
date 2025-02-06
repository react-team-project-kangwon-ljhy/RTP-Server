package org.rtpserver.domain.board.presentation.dto.req;

import java.util.List;

public record UpdateBoardRequest(
        String title,
        String contents,
        List<String> tags
) {
}
