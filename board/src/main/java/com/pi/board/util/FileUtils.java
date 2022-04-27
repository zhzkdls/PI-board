//package com.pi.board.util;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.util.*;
//
//
//public class FileUtils {
//
//    private Log log = LogFactory.getLog(this.getClass());
//
//    @Resource(name="uploadPath")
//    public List<Map<String, Object>> parseFileInfo(Map<String, Object> map, MultipartFile[] file, String uploadPath) throws Exception {
//
//        String boardIDX = String.valueOf(map.get("idx"));
//        String creaID = (String) map.get("crea_id");
//
//        List<Map<String, Object>> fileList = new ArrayList<Map<String, Object>>();
//
//        File target = new File(uploadPath);
//        if(!target.exists()) target.mkdirs();
//
//        for(int i=0; i<file.length; i++) {
//
//            String orgFileName = file[i].getOriginalFilename();
//            String orgFileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));
//            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + orgFileExtension;
//            Long saveFileSize = file[i].getSize();
//
//            log.debug("================== file start ==================");
//            log.debug("파일 실제 이름: "+orgFileName);
//            log.debug("파일 저장 이름: "+saveFileName);
//            log.debug("파일 크기: "+saveFileSize);
//            log.debug("content type: "+file[i].getContentType());
//            log.debug("================== file   END ==================");
//
//            target = new File(uploadPath, saveFileName);
//            file[i].transferTo(target);
//
//            Map<String, Object> fileInfo = new HashMap<String, Object>();
//
//            fileInfo.put("BOARD_IDX", boardIDX);
//            fileInfo.put("ORG_FILE_NAME", orgFileName);
//            fileInfo.put("SAVE_FILE_NAME", saveFileName);
//            fileInfo.put("FILE_SIZE", saveFileSize);
//            fileInfo.put("CREA_ID", creaID);
//            fileList.add(fileInfo);
//
//        }
//        return fileList;
//    }
//}
//
////    업로드할 파일들을 조작하고 업로드 기능들을 처리할 클래스를 생성한다.
////    파일 업로드는 다른 곳에서도 사용가능한 공통적인 부분이라 생각했기에 board 패키지 아래 Utils 패키지를 생성해서 그 안에 클래스를 생성했다.
//
//
//
//
