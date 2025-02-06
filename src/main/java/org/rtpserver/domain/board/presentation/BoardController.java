package org.rtpserver.domain.board.presentation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.presentation.dto.req.CreateBoardRequest;
import org.rtpserver.domain.board.presentation.dto.req.UpdateBoardRequest;
import org.rtpserver.domain.board.presentation.dto.res.BoardResponse;
import org.rtpserver.domain.board.presentation.dto.res.BoardsResponse;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CommandAPDU;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    @GetMapping
    public BoardsResponse boards() {
        return queryBoardService.getBoards();
    }

    @GetMapping("/{boardId}")
    public BoardResponse board(){
        return queryBoardService.getBoard();
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
            @PathVariable String boardId,
            @RequestHeader String accessToken,
            @RequestBody UpdateBoardRequest requestBoard
    ) {
        commandBoardService.update(accessToken, boardId, requestBoard);
    }

    @DeleteMapping("/{boardId}")
    public void delete(
            @PathVariable String boardId,
            @RequestHeader String accessToken
    ) {
        commandBoardService.delete(accessToken, boardId);
    }

}
