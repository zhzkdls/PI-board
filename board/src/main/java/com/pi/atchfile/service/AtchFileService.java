package com.pi.atchfile.service;

import com.pi.atchfile.model.AtchFile;
import org.springframework.web.multipart.MultipartFile;

public interface AtchFileService {

    void upload(AtchFile atchFile, MultipartFile file) ;



//    AttachVO findAtchFileById(Long id);
//    void deleteAtchByid(Long id);
//    List<AttachVO>getAllAtchFile();
//    AttachVO addAtchFile(AttachVO atchFile);

}


