package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> getPersonList(){
        return personRepo.findAll();
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
        System.out.println("deleting person on id:" + id);
    }

    public Person getPerson(Long id){
        return personRepo.findById(id).orElse(null);
    }

    public void addPerson(Person person) {
        Person newPerson = new Person(
                person.getFirstName(),
                person.getLastName(),
                person.getGithub(),
                person.getStart());
        personRepo.save(newPerson);
        System.out.println("adding person on id:" + newPerson.getId());
    }

    public void editPerson(Person person, Long id) {
        Person editPerson = new Person(
                id,
                person.getFirstName(),
                person.getLastName(),
                person.getGithub(),
                person.getStart(),
                person.getJava(),
                person.getBestpractice(),
                person.getTdd(),
                person.getQuestion(),
                person.getHibernate(),
                person.getHtml(),
                person.getJsp(),
                person.getThymeleaf(),
                person.getGit(),
                person.getCheckBox());
        personRepo.save(editPerson);
        System.out.println("editing person on id:" + id);
    }
}
