package com.pi.atchfile.controller;


import com.pi.atchfile.model.AtchFile;
import com.pi.atchfile.service.AtchFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/atchfile")
public class AtchFileController {

    private final AtchFileService atchFileService;

    @PostMapping("/add")
    public AtchFile addAtchFile(@RequestBody AtchFile atchFile){
        return atchFileService.addAtchFile(atchFile);
    }

    @GetMapping("/getAll")
    public List<AtchFile> getAllAtchFile(){
        return atchFileService.getAllAtchFile();
    }

    @GetMapping("/find/{id}")
    public AtchFile findAtchFileById(@PathVariable Long id){
        return atchFileService.findAtchFileById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteAtchByid(@PathVariable Long id){
        atchFileService.deleteAtchByid(id);
    }

}
