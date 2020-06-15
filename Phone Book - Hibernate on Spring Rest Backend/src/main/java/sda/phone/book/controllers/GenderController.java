package sda.phone.book.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.phone.book.model.Gender;
import sda.phone.book.repository.GenderRepo;

import java.util.List;

@RestController
@RequestMapping("gender")
@CrossOrigin(origins = "http://localhost:4200")
public class GenderController {
    private GenderRepo genderRepo;

    public GenderController(GenderRepo genderRepo) {
        this.genderRepo = genderRepo;
    }

    @GetMapping
    public List<Gender> getGender(){
        return genderRepo.getAll();
    }
}
