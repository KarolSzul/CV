package com.example.cv.controller;

import com.example.cv.model.EducationModel;
import com.example.cv.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value= "/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public String getEducation(Model model) {
        List<EducationModel> list = educationService.getAllEducation();
        model.addAttribute("educationModel", list);
        return "education/education";
    }

    @PostMapping
    @Secured("ADMIN")
    public RedirectView addEducation(EducationModel educationModel) {
            educationService.addEducation(educationModel);
            return new RedirectView("/education");
    }

    @PostMapping("/{id}")
    @Secured("ADMIN")
    public RedirectView deleteEducation(@PathVariable("id") Long id){
        educationService.deleteEducation(id);
        return new RedirectView("/education");
    }



}
