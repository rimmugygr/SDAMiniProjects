package my.rodo.services;

import my.rodo.model.Person;
import my.rodo.repository.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServices {
    PersonRepo personRepo;

    public PersonServices(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> getPersonList() {
        return personRepo.findAll();
    }

    public void addPerson(Person person) {
        personRepo.save(person);
    }

    public Person getPerson(Long id) {
        return personRepo.getOne(id);
    }

    public void editPerson(Person person, Long id) {
        person.setId(id);
        personRepo.save(person);
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}
