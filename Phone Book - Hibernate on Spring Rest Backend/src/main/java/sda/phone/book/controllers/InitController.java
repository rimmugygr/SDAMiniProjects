package sda.phone.book.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sda.phone.book.repository.GenderRepo;
import sda.phone.book.repository.PersonRepo;
import sda.phone.book.repository.PhoneRepo;

@RestController
public class InitController {
    private GenderRepo genderRepo;
    private PersonRepo personRepo;
    private PhoneRepo phoneRepo;

    public InitController(GenderRepo genderRepo, PersonRepo personRepo, PhoneRepo phoneRepo) {
        this.genderRepo = genderRepo;
        this.personRepo = personRepo;
        this.phoneRepo = phoneRepo;
    }

    @GetMapping("init")
    public String init() {
        genderRepo.init();
        return "ok";
    }

}
