package sda.phone.book.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import sda.phone.book.model.Gender;

import java.util.List;

@Service
public class GenderRepo {
    HibernateSession hibernateSession;

    public GenderRepo(HibernateSession hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public void init(){
        Gender male = new Gender();
        male.setName("M");
        Gender female = new Gender();
        female.setName("F");
        try(Session session = hibernateSession.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(male);
            session.save(female);
            transaction.commit();
        }
    }

    public List<Gender> getAll(){
        List<Gender> genders;
        try(Session session = hibernateSession.getSession()) {
            genders = session.createQuery("select g from Gender g").list();
        }
        return genders;
    }

    public Gender getById(String name) {
        try(Session session = (new HibernateSession()).getSession()) {
            return session.get(Gender.class,name);
        }
    }
}
