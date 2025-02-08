package org.rtpserver.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.domain.Board;
import org.rtpserver.domain.board.presentation.dto.res.BoardResponse;
import org.rtpserver.domain.board.presentation.dto.res.BoardsResponse;
import org.rtpserver.domain.board.service.implementation.BoardReader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryBoardService {

    private final BoardReader boardReader;

    public BoardResponse getBoard(Long boardId) {
        Board board = boardReader.findById(boardId);

        return new BoardResponse(
                board.getId(),
                board.getTitle(),
                board.getContents(),
                board.getTags()
        );
    }

    public BoardsResponse getBoards() {
        List<Board> boards = boardReader.findAll();
        List<BoardResponse> boardResponses = new ArrayList<>();

        for (Board board : boards) {
            boardResponses.add(new BoardResponse(
                    board.getId(),
                    board.getTitle(),
                    board.getContents(),
                    board.getTags()
            ));
        }

        return new BoardsResponse(boardResponses);
    }

}
