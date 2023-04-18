package com.example.cv.controller;

import com.example.cv.model.AboutModel;
import com.example.cv.service.AboutService;
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
public class AboutController {

    private final AboutService aboutService;

//    @GetMapping
//    public String getAbout(Model model){
//        List<AboutModel> list = aboutService.getAllDescription();
//        model.addAttribute("aboutModel", list);
//        return "/index";
//    }

//    @PostMapping
//    public RedirectView addAboutDescription(AboutModel aboutModel) {
//        aboutService.addAboutDescription(aboutModel);
//        return new RedirectView("/index");
//    }

    @PostMapping("/{id}")
    public RedirectView deleteAboutDescription(@PathVariable("id") Long id) {
        aboutService.deleteAboutDescription(id);
        return new RedirectView("/index");
    }

}
