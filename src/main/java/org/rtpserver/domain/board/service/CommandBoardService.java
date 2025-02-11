package org.rtpserver.domain.board.service;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.domain.Board;
import org.rtpserver.domain.board.presentation.dto.req.CreateBoardRequest;
import org.rtpserver.domain.board.presentation.dto.req.UpdateBoardRequest;
import org.rtpserver.domain.board.service.implementation.BoardCreator;
import org.rtpserver.domain.board.service.implementation.BoardDeleter;
import org.rtpserver.domain.board.service.implementation.BoardReader;
import org.rtpserver.domain.board.service.implementation.BoardUpdater;
import org.rtpserver.domain.user.service.implementation.UserReader;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandBoardService {

    private final BoardCreator boardCreator;
    private final BoardUpdater boardUpdater;
    private final BoardDeleter boardDeleter;
    private final BoardReader boardReader;
    private final UserReader usersReader;

    public void create(String accessToken, CreateBoardRequest request) {
        Long userId = jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken);

        boardCreator.save(new Board(
                usersReader.findById(userId),
                request.title(),
                request.contents(),
                request.tags()
        ));
    }

    public void update(String accessToken, Long boardId, UpdateBoardRequest request) {
        Long userId = jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken);
        Board board = boardReader.findById(boardId);

        if(board.getUser().getUserId().equals(userId)){
            boardUpdater.update(
                    board,
                    new Board(
                            request.title(),
                            request.contents(),
                            request.tags()
                    )
            );
        }
    }

    public void delete(String accessToken, Long boardId) {
        Long userId = jwtPayloadDecoder.jwtPayloadDecodeToUserId(accessToken);
        Board board = boardReader.findById(boardId);

        if(board.getUser().getUserId().equals(userId)){
            boardDeleter.delete(board);
        }
    }

}
