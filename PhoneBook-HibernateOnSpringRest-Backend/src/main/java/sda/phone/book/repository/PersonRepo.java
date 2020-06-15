package sda.phone.book.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import sda.phone.book.model.Person;
import sda.phone.book.model.Phone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PersonRepo {
    GenderRepo genderRepo;
    HibernateSession hibernateSession;

    public PersonRepo(GenderRepo genderRepo, HibernateSession hibernateSession) {
        this.genderRepo = genderRepo;
        this.hibernateSession = hibernateSession;
    }

    public void addPerson(Person person) {
        Session session = hibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }
    public  Person getPersonById(Long id) {
        Session session = hibernateSession.getSession();
        Person people = session.get(Person.class,id);
//        Person people = (Person) session.createQuery("select p from Person p where p.id=:id")
//                .setParameter("id", id)
//                .getSingleResult();
        session.close();
        return people;
    }

    public List<Person> getAllPerson() {
        Session session = hibernateSession.getSession();
        List<Person> people = session.createQuery("select p from Person p").list();
        session.close();
        return people;
    }

    public List<Person> getAllPersonSortedByNameAndNumber() {
        List<Person> people;
        try(Session session = hibernateSession.getSession()){
            people = session.createQuery("select p from Person p order by p.firstName , p.lastName").list();
            people.forEach(x -> {
                System.out.println(x.getId());
                Query query = session.createQuery("select p from Phone p where p.person.id=:id order by p.number");
                query.setParameter("id",x.getId());
                x.setPhones(query.list());
            });
        }
//        try (Session sessionn = hibernateSession.getSession()){
//            people.stream().map(Person::getId).forEach(x -> {
//                    Query query = sessionn.createQuery("select p from Phone p where p.person.id=:id order by p.id");
//                    query.setParameter("id",x);
//                    System.out.println(query.list());
//            });
//        }
        return people;
    }

    public void editPerson(Person newPerson) {
        Person dbPerson = this.getPersonById(newPerson.getId());
        if (dbPerson == null) {
           this.addPerson(newPerson);
        } else {
            setChange(newPerson, dbPerson); // set only not null change
            try (Session session = hibernateSession.getSession()){
                Transaction transaction = session.beginTransaction();
                session.update(dbPerson);
                transaction.commit();
                session.close();
            }
        }
    }

    private void setChange(Person newPerson, Person oldPerson) {
        if (newPerson.getFirstName() != null && !newPerson.getFirstName().equals("")){
            oldPerson.setFirstName(newPerson.getFirstName());
        }
        if (newPerson.getLastName() != null && !newPerson.getLastName().equals("")){
            oldPerson.setLastName(newPerson.getLastName());
        }
        if (newPerson.getAge() > 0 ){
            oldPerson.setAge(newPerson.getAge());
        }
        if (newPerson.getGender() != null && newPerson.getGender().getName() != null
                && !newPerson.getGender().getName().equals("")) {
            oldPerson.setGender(newPerson.getGender());
        }
    }

    public void deletePerson(Person person) {
        try(Session session = hibernateSession.getSession()){
            Transaction transaction = session.beginTransaction();
            Person personInDB = session.get(Person.class,person.getId());
            personInDB.getPhones().forEach(session::delete);
            session.delete(personInDB);
            transaction.commit();
        }
    }

    public List<Person> getAllPersonWithPhone() {
        Session session = hibernateSession.getSession();
        List<Person> people = session
                .createQuery("select distinct p from Person p join Phone ph on p.id = ph.person.id").list();
        session.close();
        return people;
    }
}
