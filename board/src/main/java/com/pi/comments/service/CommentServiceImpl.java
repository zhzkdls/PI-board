package com.pi.comments.service;


import com.pi.comments.model.Comment;
import com.pi.comments.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    // 이용후기 글 추가
    @Override
    public Comment addComment(Comment comment) {
        log.info("새로운 내용을 저장했습니다. : {}", comment.getContent());
        try {
            return commentRepository.save(
                    Comment.builder()
                            .id(null)
                            .content(comment.getContent())
                            .userId(comment.getUserId())
                            .stat(comment.getStat())
                            .build()
            );
        }catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }
    }


    // 모든 이용후기 글 불러오기
    @Override
    public List<Comment> findAllComment() {
        try {
            log.info("모든 내용을 리스트로 불러왔습니다.");
            return commentRepository.findAllByStat((long) 1);
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }
    }

    // 이용후기 글 삭제
    @Override
    public void deleteById(Long userId) {
        try {
            Comment comment = commentRepository.findById(userId).get();
            comment.setStat((long) 0);
            commentRepository.save(comment);
            log.info("해당된 내용을 삭제합니다.: {}", comment.getStat());
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }
    }

    // 이용후기 글 수정
    @Override
    public void updateById(Long id, Comment comment) {
        try {
            if (commentRepository.findById(id).isPresent()){
                Comment comment1 = commentRepository.findById(id).get();
                comment1 = Comment.builder()
                        .id(id)
                        .stat(comment.getStat())
                        .userId(comment1.getUserId())
                        .content(comment.getContent())
                        .build();
                log.info("해당된 내용을 수정합니다.: {}", id);
                commentRepository.save(comment1);
            }else {
                log.info("그런 내용이 없다!");
            }
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }
    }
}
