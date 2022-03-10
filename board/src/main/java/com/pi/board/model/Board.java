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
    private Long id;
    private Long pstg_seq; // 게시판일련번호
    @Column(columnDefinition = "VARCHAR(255)")
    private String pstg_title; // 게시글제목
    @Column(columnDefinition = "VARCHAR(2000)")
    private String pstg_cn; // 게시글내용
    private int pstg_gubun; // 게시판구분
    @Column(columnDefinition = "DATETIME")
    private String mdfcn_dt; // 수정일시
    @Column(columnDefinition = "CHAR(10)")
    private String pstg_pblr_name; // 게시자명
    @Column(columnDefinition = "VARCHAR(20)")
    private String user_id; // 게시자아이디
    private Long ref; // 참조
    private int step; // 스탭
    private int lvl; // 레벨
    private int cnt; //조회수
    private int stat; // 상태 -> 0: 삭제  1: 사용중


    @Builder
    public Board(Long id, Long pstg_seq, String pstg_title, String pstg_cn, int pstg_gubun, String mdfcn_dt, String pstg_pblr_name, String user_id, Long ref, int step, int lvl, int cnt, int stat) {
        this.id = id;
        this.pstg_seq = pstg_seq;
        this.pstg_title = pstg_title;
        this.pstg_cn = pstg_cn;
        this.pstg_gubun = pstg_gubun;
        this.mdfcn_dt = mdfcn_dt;
        this.pstg_pblr_name = pstg_pblr_name;
        this.user_id = user_id;
        this.ref = ref;
        this.step = step;
        this.lvl = lvl;
        this.cnt = cnt;
        this.stat = stat;
    }
}
