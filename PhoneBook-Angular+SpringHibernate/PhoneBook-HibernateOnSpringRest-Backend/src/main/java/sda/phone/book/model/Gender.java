package sda.phone.book.model;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
