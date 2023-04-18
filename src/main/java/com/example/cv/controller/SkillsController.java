package com.example.cv.controller;

import com.example.cv.model.SkillsModel;
import com.example.cv.repository.SkillsRepository;
import com.example.cv.service.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/skills")
@RequiredArgsConstructor
public class SkillsController {

    private final SkillsService skillsService;

    @GetMapping
    public String getSkills(Model model) {
        List<SkillsModel> list = skillsService.getAllSkills();
        model.addAttribute("skillsModel", list);
        return "skills/skills";
    }

    @PostMapping
    public RedirectView addSkills(SkillsModel skillsModel) {
        skillsService.addSkills(skillsModel);
        return new RedirectView("/skills");
    }

    @PostMapping("/{id}")
    public RedirectView deleteSkills(@PathVariable("id") Long id) {
        skillsService.deleteSkills(id);
        return new RedirectView("/skills");
    }



}
