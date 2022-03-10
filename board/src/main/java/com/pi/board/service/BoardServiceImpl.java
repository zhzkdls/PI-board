package com.pi.board.service;

import com.pi.board.model.Board;
import com.pi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;


    @Override
    public Board addBoard(Board board) {
        log.info("새로운 내용을 저장했습니다. : {}", board.getPstg_cn());
        try {
            return boardRepository.save(
                    Board.builder()
                            .id(board.getId())
                            .cnt(board.getCnt())
                            .lvl(board.getLvl())
                            .mdfcn_dt(board.getMdfcn_dt())
                            .pstg_cn(board.getPstg_cn())
                            .pstg_gubun(board.getPstg_gubun())
                            .pstg_pblr_name(board.getPstg_pblr_name())
                            .pstg_seq(board.getPstg_seq())
                            .pstg_title(board.getPstg_title())
                            .ref(board.getRef())
                            .stat(board.getStat())
                            .step(board.getStep())
                            .user_id(board.getUser_id())
                            .build()
            );
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }

    @Override
    public List<Board> findAllBoard() {
        try {
            log.info("모든 내용을 리스트로 불러왔습니다.");
            return boardRepository.findAll();
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }

    @Override
    public Board findBoardById(Long id) {
        log.info("해당 내용을 아이디로 찾아왔습니다. {}", id);
        try {
            return boardRepository.findById(id).get();
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }

    @Override
    public void deleteByid(Long id) {
        try {
            Board board = boardRepository.findById(id).get();
            board.setStat(0);
            boardRepository.save(board);
            log.info("해당된 내용을 삭제합니다.: {}", id);
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }


    }

    @Override
    public void updateByid(Long id, Board board) {
        try {
            if(boardRepository.findById(id).isPresent()){
                Board board1 = boardRepository.findById(id).get();
                board1 = Board.builder()
                        .id(board1.getId())
                        .cnt(board.getCnt())
                        .lvl(board.getLvl())
                        .mdfcn_dt(board.getMdfcn_dt())
                        .pstg_cn(board.getPstg_cn())
                        .pstg_gubun(board.getPstg_gubun())
                        .pstg_pblr_name(board.getPstg_pblr_name())
                        .pstg_seq(board.getPstg_seq())
                        .pstg_title(board.getPstg_title())
                        .ref(board.getRef())
                        .stat(board.getStat())
                        .step(board.getStep())
                        .user_id(board.getUser_id())
                        .build();
                log.info("해당된 내용을 수정합니다.: {}", id);
                boardRepository.save(board1);
            }else{
                log.info("그런 유저가 없다!");
            }
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }

    }
}
