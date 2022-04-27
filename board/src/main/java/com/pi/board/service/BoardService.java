package com.pi.board.service;


//import com.pi.board.dto.BoardDto;
import com.pi.board.dto.BoardDto;
import com.pi.board.model.Board;

import java.util.List;

public interface BoardService {
    Board addBoard(Board board);
    List<Board> findAllBoard();
    Board findBoardById(Long pstgSeq);
    void deleteById(Long pstgSeq);
    void updateById(Long pstgSeq, Board board);

//    List<BoardDto> search(String keyword, String type);
}
