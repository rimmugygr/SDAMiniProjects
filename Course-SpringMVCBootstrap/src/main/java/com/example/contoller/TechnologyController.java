package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TechnologyController {

    @GetMapping("technology")
    public String getTechnology(Model model) {
        return "technology";
    }

}
