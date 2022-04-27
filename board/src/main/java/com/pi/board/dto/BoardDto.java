package com.pi.board.dto;

import com.pi.board.model.Board;
import lombok.Getter;


// VO는 컬럼에 매핑된 것을 사용할 때
// DTO는 사용자 정의 모델된 것을 사용할 때
@Getter
public class BoardDto {

    private Long pstgSeq; // 게시판일련번호
    private String pstgTitle; // 게시글제목
    private String pstgCn; // 게시글내용
    private String pstgPblrName; // 게시자명

    // 검색 필터
//    private String type; //검색타입
//    private String keyword; //검색 내용


    public BoardDto(Long pstgSeq, String pstgTitle, String pstgCn, String pstgPblrName) {
        this.pstgSeq = pstgSeq;
        this.pstgTitle = pstgTitle;
        this.pstgCn = pstgCn;
        this.pstgPblrName = pstgPblrName;
    }



}
