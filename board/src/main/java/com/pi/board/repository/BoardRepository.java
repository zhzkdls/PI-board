package com.pi.board.repository;

import com.pi.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByStat(Long stat);

    //게시판 검색 조회
//    List<Board> findByPstgTitleContaining(String keyword); // 제목
//    List<Board> findByPstgCnContaining(String keyword); // 내용
//
//    // 제목 + 내용 검색
//    @Query("select p from Posts p where p.pstgCn like %:keyword% or p.pstgTitle like %:keyword%")
//    List<Board> findAllContaining(@Param("keyword") String keyword);
}
