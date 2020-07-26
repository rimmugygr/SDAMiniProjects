package my.rodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/addData")
    public String getHome() {
        return "addData";
    }

    @GetMapping("/places")
    public String getPlaces() {
        return "places";
    }

    @GetMapping("/rejestr")
    public String getRejestr() {
        return "zbiory";
    }

}
