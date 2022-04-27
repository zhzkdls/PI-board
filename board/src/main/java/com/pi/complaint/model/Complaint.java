package com.pi.complaint.model;

import com.pi.complaint.util.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Complaint extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comSeq; // 민원게시판일련번호
    @Column(columnDefinition = "VARCHAR(255)")
    private String comTitle; // 민원게시글제목
    @Column(columnDefinition = "VARCHAR(2000)")
    private String comCn; // 민원게시글내용
    private int comGubun; // 민원게시판구분
    @Column(columnDefinition = "DATETIME")
    private String mdfcnDt; // 수정일시
    @Column(columnDefinition = "CHAR(10)")
    private String comName; // 게시자명
    @Column(columnDefinition = "VARCHAR(20)")
    private String userId; // 게시자아이디

    private Long cnt; //조회수
    private Long stat; // 상태 -> 0: 삭제  1: 사용중

    @Builder
    public Complaint(Long comSeq, String comTitle, String comCn, int comGubun, String mdfcnDt, String comName, String userId, Long cnt, Long stat) {
        this.comSeq = comSeq;
        this.comTitle = comTitle;
        this.comCn = comCn;
        this.comGubun = comGubun;
        this.mdfcnDt = mdfcnDt;
        this.comName = comName;
        this.userId = userId;
        this.cnt = cnt;
        this.stat = stat;
    }
}
