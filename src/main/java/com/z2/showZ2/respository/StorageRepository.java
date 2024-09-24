package com.z2.showZ2.respository;

import com.z2.showZ2.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);
//    String getAllName();
}
