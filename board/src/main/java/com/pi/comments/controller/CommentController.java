package com.pi.comments.controller;


import com.pi.comments.model.Comment;
import com.pi.comments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    // 이용후기 글 추가
    @CrossOrigin
    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    // 모든 이용후기 글 물러오기
    @CrossOrigin
    @GetMapping("/getAll")
    public List<Comment> findAllComment(){
        return commentService.findAllComment();
    }


    // 이용후기 글 삭제
    @CrossOrigin
    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }


    // 이용후기 글 수정
    @CrossOrigin
    @PostMapping("/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody Comment comment){
        commentService.updateById(id, comment);
    }
}
