package my.rodo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Incydent extends BaseUpdateCreate{
    private String name;
    private String description;
    @OneToMany
    private List<Person> people;
    @OneToMany
    private List<Document> documents;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
