package com.example.cv.service;

import com.example.cv.model.SkillsModel;
import com.example.cv.repository.SkillsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillsService {

    private final SkillsRepository repo;

    public void addSkills(SkillsModel skillsModel) {
        repo.save(skillsModel);
    }

    public void deleteSkills(Long id) {
        repo.deleteById(id);
    }

    public List<SkillsModel> getAllSkills() {
        return repo.findAll();
    }

}
