package com.z2.showZ2.service;

import com.z2.showZ2.entity.FileData;
import com.z2.showZ2.entity.ImageData;
import com.z2.showZ2.respository.FileDataRepository;
import com.z2.showZ2.respository.StorageRepository;
import com.z2.showZ2.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Autowired
    private FileDataRepository fileDataRepository;

    private final static String FOLDER_PATH = "/Users/z2/Desktop/2/picture/test/";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = storageRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        if (imageData != null) {
            return "file uploaded successfully! : " + file.getOriginalFilename();
        }

        return "file not uploaded!";
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = storageRepository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

    public List<FileData> getAllName() {
        List<FileData> allImages = fileDataRepository.findAll();
        return allImages;
    }
}
