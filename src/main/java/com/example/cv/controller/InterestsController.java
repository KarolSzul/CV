package com.example.cv.controller;

import com.example.cv.model.InterestsModel;
import com.example.cv.repository.InterestsRepository;
import com.example.cv.service.InterestsService;
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
@RequiredArgsConstructor
@RequestMapping(value="/interests")
public class InterestsController {


    private final InterestsService interestsService;

    @GetMapping
    public String getInterests(Model model) {
        List<InterestsModel> list = interestsService.getAllInterests();
        model.addAttribute("interestsModel", list);
        return "interests/interests";
    }

    @PostMapping("/{id}")
    public RedirectView deleteInterests(@PathVariable("id") Long id) {
        interestsService.deleteInterests(id);
        return new RedirectView("/interests");
    }

    @PostMapping
    public RedirectView addInterests(InterestsModel interestsModel) {
        interestsService.addInterests(interestsModel);
        return new RedirectView("/interests");
    }

}
