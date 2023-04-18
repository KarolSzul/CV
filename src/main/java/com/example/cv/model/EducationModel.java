package com.example.cv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school")
    private String school;

    @Column(name = "degree")
    private String degree;

    @Column(name = "field_of_study")
    private String fieldOfStudy;


    @Column(name = "description")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private Date endDate;


}
