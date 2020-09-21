package my.rodo.controller;

import my.rodo.model.Person;
import my.rodo.model.Zabezpieczenia;
import my.rodo.services.PersonServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/person")
public class PersonController {
    PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping
    public String getPersons(Model model){
        model.addAttribute("persons", personServices.getPersonList());
        return "person";
    }

    @GetMapping("/add")
    public String addPerson(){
        return "personadd";
    }

    @PostMapping("/add")
    public RedirectView postPerson(@ModelAttribute Person person){
        personServices.addPerson(person);
        return new RedirectView("/person");
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable String id, Model model){
        model.addAttribute("person", personServices.getPerson(Long.parseLong(id)));
        return "personedit";
    }

    @PostMapping("/{id}/edit")
    public RedirectView postEditPerson(@PathVariable String id, @ModelAttribute Person person){
        personServices.editPerson(person,Long.parseLong(id));
        return new RedirectView("/person");
    }

    @GetMapping("/{id}/delete")
    public RedirectView deletePerson(@PathVariable String id){
        personServices.deletePerson(Long.parseLong(id));
        return new RedirectView("/person");
    }

}
