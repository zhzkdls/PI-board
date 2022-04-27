package com.pi.board.model;


import com.pi.board.util.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class Board extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pstgSeq; // 게시판일련번호
    @Column(columnDefinition = "VARCHAR(255)")
    private String pstgTitle; // 게시글제목
    @Column(columnDefinition = "VARCHAR(2000)")
    private String pstgCn; // 게시글내용
    @Column(columnDefinition = "CHAR(10)")
    private String pstgPblrName; // 게시자명

//    @Column(columnDefinition = "VARCHAR(20)")
//    private String userId; // 게시자아이디

//    @Column(columnDefinition = "DATETIME")
//    private String mdfcnDt; // 수정일시
    //    private Long ref; // 참조
    //    private Long step; // 스탭
    //    private Long lvl; // 레벨
    //    private Long cnt; //조회수
    //    private int pstgGubun; // 게시판구분
    private Long stat; // 상태 -> 0: 삭제  1: 사용중


    @Builder
    public Board(Long pstgSeq, String pstgTitle, String pstgCn, String pstgPblrName, Long stat) {
        this.pstgSeq = pstgSeq;
        this.pstgTitle = pstgTitle;
        this.pstgCn = pstgCn;
        this.pstgPblrName = pstgPblrName;
        this.stat = stat;
    }
}
