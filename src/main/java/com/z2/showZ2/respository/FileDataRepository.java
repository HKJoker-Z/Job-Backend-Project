package com.z2.showZ2.respository;

import com.z2.showZ2.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData, Integer> {

    Optional<FileData> findByName(String fileName);
}
