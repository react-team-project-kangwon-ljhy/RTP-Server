package org.rtpserver.domain.board.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.domain.Board;
import org.rtpserver.domain.board.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardDeleter {

    private final BoardRepository boardRepository;

    public void delete(Board board) {
        boardRepository.delete(board);
    }
}
