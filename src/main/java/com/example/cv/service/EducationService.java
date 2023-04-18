package com.example.cv.service;

import com.example.cv.model.EducationModel;
import com.example.cv.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository repo;

    public void addEducation(EducationModel education) {
        repo.save(education);
    }

    public void deleteEducation(Long id) {
        repo.deleteById(id);
    }

    public List<EducationModel> getAllEducation() {
       return repo.findAll();
    }

    public void saveEditStudent(EducationModel editEducationModel) {
        repo.save(editEducationModel);
    }



}
