package org.rtpserver.domain.board.service.implementation;

import lombok.RequiredArgsConstructor;
import org.rtpserver.domain.board.domain.Board;
import org.rtpserver.domain.board.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardReader {

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

//    public List<Board> findAllByUser(Users user) {
//        return boardRepository.findAllByUser();
//    }

}
