package com.pi.atchfile.model;


import com.pi.board.util.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Data
public class AtchFile extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atch_file_seq; // 첨부파일 일련번호
    private Long pstg_seq; //게시판 일련번호
    @Column(columnDefinition = "VARCHAR(255)")
    private String or_file_name; //원본 파일명
    @Column(columnDefinition = "VARCHAR(255)")
    private String sv_file_name; // 저장 파일명
    @Column(columnDefinition = "VARCHAR(255)")
    private String file_path; // 파일 경로
    @Column(columnDefinition = "INTEGER")
    private Long file_size; // 파일 크기
    @Column(columnDefinition = "DATETIME")
    private String file_mdfcn_dt; // 파일 수정 일시

    @Builder
    public AtchFile(Long atch_file_seq, Long pstg_seq, String or_file_name, String sv_file_name, String file_path, Long file_size, String file_mdfcn_dt) {
        this.atch_file_seq = atch_file_seq;
        this.pstg_seq = pstg_seq;
        this.or_file_name = or_file_name;
        this.sv_file_name = sv_file_name;
        this.file_path = file_path;
        this.file_size = file_size;
        this.file_mdfcn_dt = file_mdfcn_dt;
    }
}
