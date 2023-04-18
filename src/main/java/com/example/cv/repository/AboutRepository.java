package com.example.cv.repository;

import com.example.cv.model.AboutModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AboutRepository extends JpaRepository<AboutModel, Long> {
}
