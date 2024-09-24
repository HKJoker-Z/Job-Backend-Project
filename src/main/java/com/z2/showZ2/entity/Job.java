package com.z2.showZ2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type;
    private String location;
    //let description column be longtext type
    @Column(columnDefinition="TEXT")
    private String description;
    private String salary;    //it's salary prev in front
    private String companyName; //it's "Julian Zhao" by default prev company.name in front

    @Column(columnDefinition="TEXT")
    private String companyDescription;
    private String companyEmail;
    private String companyPhone;
}
