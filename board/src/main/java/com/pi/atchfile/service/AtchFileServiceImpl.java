package com.pi.atchfile.service;

import com.pi.atchfile.model.AtchFile;
import com.pi.atchfile.repository.AtchFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class AtchFileServiceImpl implements AtchFileService{


    private final AtchFileRepository atchFileRepository;

    // 일반파일업로드
    @Transactional
    @Override
    public void upload(AtchFile attachVO, MultipartFile file) {
        atchFileRepository.save(attachVO);
    }


    //    @Override
//    public AttachVO addAtchFile(AttachVO atchFile) {
//        log.info("새로운 파일을 저장했습니다. : {}", atchFile.getSv_file_name());
//        try {
//            return atchFileRepository.save(
//                    AttachVO.builder()
//                            .atch_file_seq(atchFile.getAtch_file_seq())
//                            .file_mdfcn_dt(atchFile.getFile_mdfcn_dt())
//                            .file_path(atchFile.getFile_path())
//                            .file_size(atchFile.getFile_size())
//                            .or_file_name(atchFile.getOr_file_name())
//                            .pstg_seq(atchFile.getPstg_seq())
//                            .sv_file_name(atchFile.getSv_file_name())
//                            .build()
//            );
//        } catch (Exception e) {
//            log.error("에러!!: {}", e.getMessage());
//            return null;
//        }
//
//    }
//
//    @Override
//    public List<AttachVO> getAllAtchFile() {
//        try{
//            log.info("모든 파일을 불러왔습니다.");
//            return atchFileRepository.findAll();
//        }catch (Exception e){
//            log.error(e.getMessage());
//            log.info("ERROR!!");
//            return null;
//        }
//    }
//
//    @Override
//    public AttachVO findAtchFileById(Long id) {
//        log.info("해당 파일을 찾아왔습니다. {}", id);
//        try {
//            return atchFileRepository.findById(id).get();
//        } catch (Exception e) {
//            log.error("에러!!: {}", e.getMessage());
//            return null;
//        }
//    }
//
//    @Override
//    public void deleteAtchByid(Long id) {
//        try {
//            atchFileRepository.deleteById(id);
//            log.info("해당된 내용을 삭제합니다.: {}", id);
//        } catch (Exception e) {
//            log.error("에러!!: {}", e.getMessage());
//        }
//
//    }
}
