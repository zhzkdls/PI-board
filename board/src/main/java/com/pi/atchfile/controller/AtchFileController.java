package com.pi.atchfile.controller;

import com.pi.atchfile.model.AtchFile;
import com.pi.atchfile.service.AtchFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/atchfile")
public class AtchFileController {
    private final AtchFileService atchFileService;


    public String upload(AtchFile atchFile, @RequestParam("file") MultipartFile file) throws Exception{
        try {
//            String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String ymd = "", yyyy = "", mm = "", dd = "";
            String ymdPath = "", savePath = "";

            ymd = sdf.format(cal.getTime());

            yyyy = ymd.substring(0, 4);
            mm = ymd.substring(4, 6);
            dd = ymd.substring(6);

            ymdPath = yyyy + "/" + mm + "/" + dd;
            savePath = yyyy + "/" + mm + "/" + dd;

            String or_file_name = file.getOriginalFilename(); //파일명
            long file_size = file.getSize(); //파일 사이즈

            System.out.println("파일명:" + or_file_name);
            System.out.println("파일 사이즈:" + file_size);

            //서버에서 저장할 파일 이름
            String fileExtension = or_file_name.substring(or_file_name.lastIndexOf("."),or_file_name.length());
            String uploadFolder = "C:\\test\\upload";

			/*
			  파일 업로드 시 파일명이 동일한 파일이 이미 존재할 수도있고,
			  사용자가 업로드하는 파일명이 영어 이외의 언어로 되어있을 수 있습니다.
			  타 언어를 지원하지 않는 환경에서는 정상 동작이 되지 않습니다.
			 */
            UUID uuid = UUID.randomUUID();
            String[] uuids = uuid.toString().split("-");
            String uniqueName = uuids[0];
            System.out.println("생성된 고유 문자열" + uniqueName);



            File saveFile = new File(uploadFolder+ "\\" + uniqueName + fileExtension);
            //실제 파일 저장 메서드(fileWriter작업을 손쉽게 한방에 처리해 줍니다.)
            file.transferTo(saveFile);
            String fileName = uuid + "_" + file.getOriginalFilename();

            file.transferTo(saveFile);
            atchFile.setSv_file_name(fileName);
            atchFile.setFile_path("/upload/" + fileName);
            atchFileService.upload(atchFile,file);

        }catch (Exception e) {
            log.error("에러!!: {}", e.getMessage());
        }
        atchFileService.upload(atchFile, file);
        return "/upload";
    }

}

//    @PostMapping("/add")
//    public AttachVO addAtchFile(@RequestBody AttachVO atchFile){
//        return attachVOService.addAtchFile(atchFile);
//    }
//
//    @GetMapping("/getAll")
//    public List<AttachVO> getAllAtchFile(){
//        return atchFileService.getAllAtchFile();
//    }
//
//    @GetMapping("/find/{id}")
//    public AttachVO findAtchFileById(@PathVariable Long id){
//        return atchFileService.findAtchFileById(id);
//    }
//
//    @PostMapping("/delete/{id}")
//    public void deleteAtchByid(@PathVariable Long id){
//        atchFileService.deleteAtchByid(id);
//    }


