package com.example.contoller;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/addperson")
    public String addPerson(Model model) {
        return "personPages/addNewPerson";
    }

    @PostMapping("/addperson")
    public RedirectView postPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return new RedirectView("/personlist");
    }

    @GetMapping("/editperson/{id}")
    public String editPersonView(@PathVariable String id, Model model) {
        model.addAttribute("person", personService.getPerson(Long.parseLong(id)));
        return "personPages/editPerson";
    }

    @PostMapping("/editperson/{id}")
    public RedirectView editPerson(@PathVariable String id, @ModelAttribute Person person) {
        personService.editPerson(person, Long.parseLong(id));
        return new RedirectView("/personlist");
    }

    @PostMapping("/deleteperson/{id}")
    public RedirectView deletePerson(@PathVariable String id) {
        personService.deletePerson(Long.parseLong(id));
        return new RedirectView("/personlist");
    }

    @GetMapping("/personlist")
    public String personList(Model model) {
        List<Person> personList = personService.getPersonList();
        model.addAttribute("persons",personList);
        return "personPages/personList";
    }
}
