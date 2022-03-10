package com.pi.board.controller;


import com.pi.board.model.Board;
import com.pi.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/add")
    public Board addBoard(@RequestBody Board board){
        return boardService.addBoard(board);
//        return "저장완료";
    }

    @GetMapping("/getAllBoard")
    public List<Board> findAllBoard(){
        return boardService.findAllBoard();
    }

    @GetMapping("/findBoard/{id}")
    public Board findBoardById(@PathVariable Long id){
        return boardService.findBoardById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteByid(@PathVariable Long id){
        boardService.deleteByid(id);
    }

    @PostMapping("/update/{id}")
    public void updateByid(@PathVariable Long id, @RequestBody Board board){
        boardService.updateByid(id, board);
    }



}
