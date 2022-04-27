package com.pi.complaint.service;


import com.pi.board.model.Board;
import com.pi.complaint.dto.ComplaintDto;
import com.pi.complaint.model.Complaint;
import com.pi.complaint.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ComplaintServiceImpl implements ComplaintService{

   private final ComplaintRepository complaintRepository;


    // 게시글 추가
    @Override
    public Complaint addComplaint(Complaint complaint) {
        log.info("새로운 내용을 저장했습니다. : {}", complaint.getComCn());
        try {
            return complaintRepository.save(
                    Complaint.builder()
                            .userId(complaint.getUserId())
                            .stat(complaint.getStat())
                            .mdfcnDt(complaint.getMdfcnDt())
                            .comTitle(complaint.getComTitle())
                            .comSeq(complaint.getComSeq())
                            .cnt(complaint.getCnt())
                            .comName(complaint.getComName())
                            .comGubun(complaint.getComGubun())
                            .comCn(complaint.getComCn())
                            .build()
            );
        }catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }
    }

    // 모든 게시글 불러오기
    @Override
    public List<Complaint> findAllComplaint() {
        try {
            log.info("모든 내용을 리스트로 불러왔습니다.");

            return complaintRepository.findAllByStat((long) 1);
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }
    }

    // 게시글 1개 찾음
    @Override
    public Complaint findComplaintById(Long comSeq) {
        log.info("해당 내용을 아이디로 찾아왔습니다. {}", comSeq);
        try {
            return complaintRepository.findById(comSeq).get();
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
            return null;
        }
    }

    // 게시글 삭제
    @Override
    public void deleteById(Long comSeq) {
        try{
            Complaint complaint = complaintRepository.findById(comSeq).get();
            complaint.setStat((long) 0);
            complaintRepository.save(complaint);
            log.info("해당된 내용을 삭제합니다.: {}", complaint.getStat());
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }
    }

    // 게시글 수정
    @Override
    public void updateById(Long comSeq, Complaint complaint) {
        try {
            if (complaintRepository.findById(comSeq).isPresent()){
                Complaint complaint1 = complaintRepository.findById(comSeq).get();
                complaint1 = Complaint.builder()
                        .cnt(complaint.getCnt())
                        .comCn(complaint.getComCn())
                        .comGubun(complaint.getComGubun())
                        .comName(complaint.getComName())
                        .comSeq(complaint1.getComSeq())
                        .comTitle(complaint.getComTitle())
                        .mdfcnDt(complaint.getMdfcnDt())
                        .stat(complaint.getStat())
                        .userId(complaint.getUserId())
                        .build();
                log.info("해당된 내용을 수정합니다.: {}", comSeq);
                complaintRepository.save(complaint1);
            }else {
                log.info("그런 내용이 없다!");
            }
        } catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }
    }

    //조회수 카운트
    @Override
    public void updateCount(ComplaintDto complaintDto) {
        Complaint complaint = complaintRepository.findById(complaintDto.getComSeq()).get();
        complaint.setCnt(complaintDto.getCnt());
        complaintRepository.save(complaint);
    }

    //    // 게시글 조회
//    @Override
//    public List<BoardDto> search(String keyword, String type) {
//        // 제목 검색
//        if(type.equals("pstgTitle")) {
//            return boardRepository.findByPstgTitleContaining(keyword).stream()
//                    .map(BoardDto::new)
//                    .collect(Collectors.toList());
//        }
//        // 내용 검색
//        else if(type.equals("pstgCn")) {
//            return boardRepository.findByPstgCnContaining(keyword).stream()
//                    .map(BoardDto::new)
//                    .collect(Collectors.toList());
//        }
//        // 제목 + 내용 검색
//        else {
//            return boardRepository.findAllContaining(keyword).stream()
//                    .map(BoardDto::new)
//                    .collect(Collectors.toList());
//        }
//    }
}
