package com.example.cv.service;

import com.example.cv.model.EducationModel;
import com.example.cv.model.ExperienceModel;
import com.example.cv.repository.EducationRepository;
import com.example.cv.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository repo;

    public void addExperience(ExperienceModel experienceModel) {
        repo.save(experienceModel);
    }

    public void deleteExperience(Long id) {
        repo.deleteById(id);
    }

    public List<ExperienceModel> getAllExperience() {
       return repo.findAll();
    }


}
