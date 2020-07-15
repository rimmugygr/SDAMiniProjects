package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    //@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "loginPages/login";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        return "loginPages/register";
    }

}
