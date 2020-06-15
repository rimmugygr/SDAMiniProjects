package sda.phone.book.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sda.phone.book.model.Person;
import sda.phone.book.repository.PersonRepo;

import java.util.List;

@RestController
@RequestMapping("person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping
    public List<Person> getPersons() {
        return personRepo.getAllPerson();
    }

    @GetMapping("/phone")
    public List<Person> getPersonsWithPhone() {
        return personRepo.getAllPersonWithPhone();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable(name = "id") long id) {
        return personRepo.getPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPerson(@RequestBody Person person) {
        personRepo.addPerson(person);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void patchPerson(@RequestBody Person person) {
        personRepo.editPerson(person);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletePersons(@RequestBody Person person) {
        personRepo.deletePerson(person);
    }
}
