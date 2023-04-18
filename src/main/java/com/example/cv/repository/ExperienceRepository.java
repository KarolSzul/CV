package com.example.cv.repository;

import com.example.cv.model.EducationModel;
import com.example.cv.model.ExperienceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<ExperienceModel, Long> {
}
