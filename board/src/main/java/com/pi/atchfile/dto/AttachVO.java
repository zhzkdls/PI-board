package com.pi.atchfile.dto;


import lombok.Data;


@Data
public class AttachVO {

    private Long atch_file_seq; // 첨부파일 일련번호
    private Long pstg_seq; //게시판 일련번호
    private String or_file_name; //원본 파일명
    private String sv_file_name; // 저장 파일명
    private String file_path; // 파일 경로
    private Long file_size; // 파일 크기
    private String file_mdfcn_dt; // 파일 수정 일시
}
