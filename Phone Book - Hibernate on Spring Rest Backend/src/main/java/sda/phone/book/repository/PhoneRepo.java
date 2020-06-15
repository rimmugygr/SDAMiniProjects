package sda.phone.book.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import sda.phone.book.model.Person;
import sda.phone.book.model.Phone;

import java.util.List;

@Service
public class PhoneRepo {
    HibernateSession hibernateSession;

    public PhoneRepo(HibernateSession hibernateSession) {
        this.hibernateSession = hibernateSession;
    }

    public List<Phone> getAllPhones() {
        try (Session session = hibernateSession.getSession()){
            return session.createQuery("select p from Phone p order by p.id").list();
        }
    }

    public void addPhone(Phone phone) {
        try (Session session = hibernateSession.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
        }
    }

    public Phone getPhoneById(long id) {
        try (Session session = hibernateSession.getSession()){
            return session.get(Phone.class, id);
        }
    }

    public void editPerson(Phone newPhone) {
        Phone oldPhone = this.getPhoneById(newPhone.getId());
        if (oldPhone == null) {
            this.addPhone(newPhone);
        } else {
            setChange(newPhone, oldPhone);
            try (Session session = hibernateSession.getSession()){
                Transaction transaction = session.beginTransaction();
                session.update(oldPhone);
                transaction.commit();
                session.close();
            }
        }
    }

    private void setChange(Phone phoneInput, Phone editPhone) {
        if (phoneInput.getNumber() != null){
            editPhone.setNumber(phoneInput.getNumber());
        }
        if (phoneInput.getPerson() != null){
            editPhone.setPerson(phoneInput.getPerson());
        }
    }

    public void deletePhone(Phone phone) {
        try (Session session = hibernateSession.getSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(phone);
            transaction.commit();
        }
    }

    public void deletePhonesByPersonId(long id) {
        try (Session session = hibernateSession.getSession()){
            Transaction transaction = session.beginTransaction();
            Query query = session.createSQLQuery("delete from phone where phone.person_id=?");
            query.setParameter(1,id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    public void addNumberToPerson(String number, long id) {
        Phone phone = new Phone(number,new Person(id));
        try (Session session = hibernateSession.getSession()){
            Transaction transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
        }
    }

    public List<Phone> getAllPhonesByPersonId(long id) {
        try (Session session = hibernateSession.getSession()){
            Query query = session.createQuery("select p from Phone p where p.person.id=:id order by p.id");
            query.setParameter("id",id);
            return query.list();
        }
    }
}
