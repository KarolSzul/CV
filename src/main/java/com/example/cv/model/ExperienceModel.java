package com.example.cv.model;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "position")
    private String position;

    @Column(name = "company")
    private String company;

    @Column(name = "responsibilities")
    private String responsibilities;

    @DateTimeFormat(pattern = "yyyy-MM")
    @Column(name = "start_date")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM")
    @Column(name = "end_date")
    private Date endDate;

}
