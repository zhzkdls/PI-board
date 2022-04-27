package com.pi.board.controller;


import com.pi.atchfile.controller.AtchFileController;
import com.pi.atchfile.service.AtchFileService;
import com.pi.board.dto.BoardDto;
import com.pi.board.model.Board;
import com.pi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;
    private final AtchFileService atchFileService;

//    @Autowired
//    private AtchFileController atchFileController;


    // 게시글 추가
    @CrossOrigin
    @PostMapping("/posts")
    public Board addBoard(@RequestBody Board board){
        return boardService.addBoard(board);
    }
//    @PostMapping("/add")
//    public Board addBoard( Board board,
//                          @RequestParam("file")MultipartFile file,
//                           HttpServletRequest request,
//                           HttpServletResponse response
//                          ){
//
//        Board result = boardService.addBoard(board);
//        System.out.println(result.getPstg_seq());
//        if (result.getPstg_seq() > 0){
//            System.out.println(file.getOriginalFilename());
//
//
//
//            AtchFileController at = new AtchFileController(atchFileService);
////            HashMap<String, Object> map = at.upload(file, "");
//
//
////            FileController fc = new FileController();
////            Attach attach = new Attach();
////            attach.setFileNma
////                    setFileSize
////                    setFilePath
////                            setSaveFileName
//        }
//
//        return null;
//        //return boardService.addBoard(board);
//    }

    // 모든 게시글 물러오기
    @CrossOrigin
    @GetMapping("/getAll")
    public List<Board> findAllBoard(){
        return boardService.findAllBoard();
    }

    // 게시글 1개 찾움
    @CrossOrigin
    @GetMapping("/find/{pstgSeq}")
    public Board findBoardById(@PathVariable Long pstgSeq){
        return boardService.findBoardById(pstgSeq);
    }


    // 게시글 삭제
    @CrossOrigin
    @PostMapping("/delete/{pstgSeq}")
    public void deleteById(@PathVariable Long pstgSeq){
        boardService.deleteById(pstgSeq);
    }


    // 게시글 수정
    @CrossOrigin
    @PostMapping("/update/{pstgSeq}")
    public void updateById(@PathVariable Long pstgSeq, @RequestBody Board board){
        boardService.updateById(pstgSeq, board);
    }

    // 게시글 검색
//    @CrossOrigin
//    @GetMapping("/api/search/{keyword}/{type}")
//    public List<BoardDto> search(@PathVariable String keyword, @PathVariable String type) {
//        return boardService.search(keyword, type);
//    }



}
