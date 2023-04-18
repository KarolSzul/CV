package com.example.cv.service;

import com.example.cv.model.AboutModel;
import com.example.cv.repository.AboutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AboutService {

    private AboutRepository repo;


    public void addAboutDescription(AboutModel aboutModel) {
        repo.save(aboutModel);
    }

    public List<AboutModel> getAllDescription() {
        return repo.findAll();
    }

    public void deleteAboutDescription(Long id) {
        repo.deleteById(id);
    }


}
