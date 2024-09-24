package com.z2.showZ2.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Photo {

    @Id
    private Integer id;
    private String fileName;
    private String filePath;
    private String fileType;
    private String fileSize;
    private String fileUrl;
    private String createTime;
}
