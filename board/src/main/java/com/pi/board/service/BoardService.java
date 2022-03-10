package com.pi.board.service;


import com.pi.board.model.Board;

import java.util.List;

public interface BoardService {
    Board addBoard(Board board);
    List<Board> findAllBoard();
    Board findBoardById(Long id);
    void deleteByid(Long id);
    void updateByid(Long id, Board board);

}
