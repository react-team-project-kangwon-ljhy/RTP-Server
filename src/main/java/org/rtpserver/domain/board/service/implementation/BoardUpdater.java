package org.rtpserver.domain.board.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.domain.Board;
import org.rtpserver.domain.board.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardUpdater {

    private final BoardRepository boardRepository;

    public void update(Board updatableBoard, Board board) {
        updatableBoard.update(
                board.getTitle(),
                board.getContents(),
                board.getTags()
        );

        boardRepository.save(updatableBoard);
    }

}
