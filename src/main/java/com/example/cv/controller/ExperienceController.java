package com.example.cv.controller;


import com.example.cv.model.EducationModel;
import com.example.cv.model.ExperienceModel;
import com.example.cv.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value ="/experience")
public class ExperienceController {

    private final ExperienceService experienceService;
    @GetMapping
    public String getExperience(Model model) {
        List<ExperienceModel> list = experienceService.getAllExperience();
        model.addAttribute("experienceModel", list);
        return "experience/experience";
    }

    @PostMapping
    @Secured("ADMIN")
    public RedirectView addExperience(ExperienceModel experienceModel) {
        experienceService.addExperience(experienceModel);
        return new RedirectView("/experience");
    }

    @PostMapping("/{id}")
    @Secured("ADMIN")
    public RedirectView deleteExperience(@PathVariable("id") Long id){
        experienceService.deleteExperience(id);
        return new RedirectView("/experience");
    }

}
