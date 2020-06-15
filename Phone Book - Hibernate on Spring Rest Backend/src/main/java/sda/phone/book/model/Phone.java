package sda.phone.book.model;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;


import javax.persistence.*;

@Entity
@Table(name = "phone")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Phone {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id")
    //@JsonManagedReference // for parent
    @JsonBackReference //for child
    private Person person;

    public Phone() {
    }

    public Phone(String number, Person person) {
        this.number = number;
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
