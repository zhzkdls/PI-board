package com.pi.complaint.service;

import com.pi.complaint.dto.ComplaintDto;
import com.pi.complaint.model.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint addComplaint(Complaint complaint);
    List<Complaint> findAllComplaint();
    Complaint findComplaintById(Long comSeq);
    void deleteById(Long comSeq);
    void updateById(Long comSeq, Complaint complaint);
    void updateCount(ComplaintDto complaintDto);

    //    List<BoardDto> search(String keyword, String type);
}
