package com.pi.atchfile.service;

import com.pi.atchfile.model.AtchFile;

import java.util.List;

public interface AtchFileService {
    AtchFile addAtchFile(AtchFile atchFile);
    List<AtchFile>getAllAtchFile();
    AtchFile findAtchFileById(Long id);
    void deleteAtchByid(Long id);
}
