package com.example.contoller;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Person;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @GetMapping({"/","/index"})
    public String getIndex(Authentication authentication, Model model){
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            model.addAttribute("userhello", "Hello " + authentication.getName() + " with " + authentication.getAuthorities().toString())             ;
        }

        return "index";
    }


}
