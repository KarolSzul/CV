package com.example.cv.service;

import com.example.cv.model.InterestsModel;
import com.example.cv.repository.InterestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterestsService {

    private final InterestsRepository repo;

    public void addInterests(InterestsModel interestsModel) {
        repo.save(interestsModel);
    }

    public void deleteInterests(Long id){
        repo.deleteById(id);
    }

    public List<InterestsModel> getAllInterests() {
        return repo.findAll();
    }
}
