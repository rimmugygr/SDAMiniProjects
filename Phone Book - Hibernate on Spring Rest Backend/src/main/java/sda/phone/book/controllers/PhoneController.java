package sda.phone.book.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sda.phone.book.model.Person;
import sda.phone.book.model.Phone;
import sda.phone.book.repository.PhoneRepo;

import java.util.List;

@RestController
@RequestMapping("/phone")
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneController {
    PhoneRepo phoneRepo;

    public PhoneController(PhoneRepo phoneRepo) {
        this.phoneRepo = phoneRepo;
    }

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneRepo.getAllPhones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addPhone(@RequestBody Phone phone) {
        phoneRepo.addPhone(phone);
    }

    @GetMapping("/{id}")
    public Phone getPhone(@PathVariable(name = "id") long id) {
        return phoneRepo.getPhoneById(id);
    }

    @PostMapping("/{number}/person/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNumberToPerson(@PathVariable(name = "number") String number, @PathVariable(name = "id") long id) {
        phoneRepo.addNumberToPerson(number,id);
    }

    @GetMapping("/person/{id}")
    public List<Phone> getAllPhonesByPersonId(@PathVariable(name = "id") long id) {
        return phoneRepo.getAllPhonesByPersonId(id);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void patchPerson(@RequestBody Phone phone) {
        phoneRepo.editPerson(phone);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletePhone(@RequestBody Phone phone) {
        phoneRepo.deletePhone(phone);
    }

    @DeleteMapping("/person/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllPhonesByPersonId(@PathVariable(name = "id") long id) {
        phoneRepo.deletePhonesByPersonId(id);
    }
}
