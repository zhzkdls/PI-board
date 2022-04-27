package com.pi.comments.service;

import com.pi.comments.model.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> findAllComment();
    void deleteById(Long id);
    void updateById(Long id, Comment comment);
}
