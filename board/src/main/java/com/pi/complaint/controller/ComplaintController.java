package com.pi.complaint.controller;


import com.pi.complaint.dto.ComplaintDto;
import com.pi.complaint.model.Complaint;
import com.pi.complaint.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;


    // 게시글 추가
    @CrossOrigin
    @PostMapping("/post/add")
    public Complaint addComplaint(@RequestBody Complaint complaint){
        return complaintService.addComplaint(complaint);
    }

    // 모든 게시글 물러오기
    @CrossOrigin
    @GetMapping("/getAll")
    public List<Complaint> findAllComplaint(){
        return complaintService.findAllComplaint();
    }

    // 게시글 1개 찾움
    @CrossOrigin
    @GetMapping("/find/{comSeq}")
    public Complaint findComplaintById(@PathVariable Long comSeq){
        return complaintService.findComplaintById(comSeq);
    }


    // 게시글 삭제
    @CrossOrigin
    @PostMapping("/delete/{comSeq}")
    public void deleteById(@PathVariable Long comSeq){
        complaintService.deleteById(comSeq);
    }


    // 게시글 수정
    @CrossOrigin
    @PostMapping("/update/{comSeq}")
    public void updateById(@PathVariable Long comSeq, @RequestBody Complaint complaint){
        complaintService.updateById(comSeq, complaint);
    }

    // 조회수 카운트
    @CrossOrigin
    @PostMapping("/count/{comSeq}")
    public void updateCount(@PathVariable Long comSeq ,@RequestBody ComplaintDto complaintDto){
        log.info(complaintDto.toString());
        complaintService.updateCount(complaintDto);
    }

    //    // 게시글 검색
//    @CrossOrigin
//    @GetMapping("/api/search/{keyword}/{type}")
//    public List<BoardDto> search(@PathVariable String keyword, @PathVariable String type) {
//        return boardService.search(keyword, type);
//    }
}
