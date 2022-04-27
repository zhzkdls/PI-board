package com.pi.board.service;

import com.pi.atchfile.repository.AtchFileRepository;
import com.pi.board.dto.BoardDto;
import com.pi.board.model.Board;
import com.pi.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final AtchFileRepository atchFileRepository;




    // 게시글 추가
    @Override
    public Board addBoard(Board board) {
        log.info("새로운 내용을 저장했습니다. : {}", board.getPstgCn());
//        Long id = 0L;

        try {
            return boardRepository.save(
                    Board.builder()
                            .pstgCn(board.getPstgCn())
                            .pstgPblrName(board.getPstgPblrName())
                            .pstgSeq(board.getPstgSeq())
                            .pstgTitle(board.getPstgTitle())
                            .stat(board.getStat())
                            .build()
            );
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }

    // 모든 게시글 불러오기
    @Override
    public List<Board> findAllBoard() {
        try {
            log.info("모든 내용을 리스트로 불러왔습니다.");

            return boardRepository.findAllByStat((long) 1);
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }

    // 게시글 1개 찾음
    @Override
    public Board findBoardById(Long pstgSeq) {
        log.info("해당 내용을 아이디로 찾아왔습니다. {}", pstgSeq);
        try {
            return boardRepository.findById(pstgSeq).get();
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }

    }


    // 게시글 삭제
    @Override
    public void deleteById(Long pstgSeq) {
        try {
            Board board = boardRepository.findById(pstgSeq).get();
            board.setStat((long) 0);
            boardRepository.save(board);
            log.info("해당된 내용을 삭제합니다.: {}", board.getStat());
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }


    }

    // 게시글 수정
    @Override
    public void updateById(Long pstgSeq, Board board) {
        try {
            if(boardRepository.findById(pstgSeq).isPresent()){
                Board board1 = boardRepository.findById(pstgSeq).get();
                board1 = Board.builder()
                        .pstgCn(board.getPstgCn())
                        .pstgPblrName(board.getPstgPblrName())
                        .pstgSeq(board1.getPstgSeq())
                        .pstgTitle(board.getPstgTitle())
                        .stat(board.getStat())
                        .build();
                log.info("해당된 내용을 수정합니다.: {}", pstgSeq);
                boardRepository.save(board1);
            }else{
                log.info("그런 내용이 없다!");
            }
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }

    }

    // 게시글 조회
//    @Override
//    public List<BoardDto> search(String keyword, String type) {
//        // 제목 검색
//        if(type.equals("pstgTitle")) {
//            return boardRepository.findByPstgTitleContaining(keyword).stream()
//                    .map(BoardDto::new)
//                    .collect(Collectors.toList());
//        }
//        // 내용 검색
//        else if(type.equals("pstgCn")) {
//            return boardRepository.findByPstgCnContaining(keyword).stream()
//                    .map(BoardDto::new)
//                    .collect(Collectors.toList());
//        }
//        // 제목 + 내용 검색
//        else {
//            return boardRepository.findAllContaining(keyword).stream()
//                    .map((Long pstgSeq) -> new BoardDto(pstgSeq))
//                    .collect(Collectors.toList());
//        }
//    }
}
