package com.pi.atchfile.repository;


import com.pi.atchfile.model.AtchFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtchFileRepository extends JpaRepository<AtchFile, Long> {
}
