package org.rtpserver.domain.board.presentation.dto.res;

import java.util.List;

public record BoardResponse(
        Long boardId,
        String title,
        String contents,
        List<String> tags
) {
}
