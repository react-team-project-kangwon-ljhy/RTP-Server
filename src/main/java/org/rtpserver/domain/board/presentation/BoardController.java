package org.rtpserver.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.presentation.dto.req.CreateBoardRequest;
import org.rtpserver.domain.board.presentation.dto.req.UpdateBoardRequest;
import org.rtpserver.domain.board.presentation.dto.res.BoardResponse;
import org.rtpserver.domain.board.presentation.dto.res.BoardsResponse;
import org.rtpserver.domain.board.service.CommandBoardService;
import org.rtpserver.domain.board.service.QueryBoardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final QueryBoardService queryBoardService;
    private final CommandBoardService commandBoardService;

    @GetMapping
    public BoardsResponse boards() {
        return queryBoardService.getBoards();
    }

    @GetMapping("/{boardId}")
    public BoardResponse board(
            @PathVariable Long boardId
    ){
        return queryBoardService.getBoard(boardId);
    }

    @PostMapping
    public void create(
            @RequestHeader String accessToken,
            @RequestBody CreateBoardRequest requestBoard
    ) {
        commandBoardService.create(accessToken, requestBoard);
    }

    @PutMapping("/{boardId}")
    public void update(
            @PathVariable Long boardId,
            @RequestHeader String accessToken,
            @RequestBody UpdateBoardRequest requestBoard
    ) {
        commandBoardService.update(accessToken, boardId, requestBoard);
    }

    @DeleteMapping("/{boardId}")
    public void delete(
            @PathVariable Long boardId,
            @RequestHeader String accessToken
    ) {
        commandBoardService.delete(accessToken, boardId);
    }

}
