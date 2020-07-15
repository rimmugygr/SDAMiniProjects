package com.example.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private Level level;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadline;
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @Lob
    private String content;
    @ManyToOne(targetEntity = Person.class)
    private Person person;

    public Task() {
    }

    public Task(Level level, LocalDate deadline, LocalDate createDate, String content, Person person) {
        this.level = level;
        this.deadline = deadline;
        this.createDate = createDate;
        this.content = content;
        this.person = person;
    }

    public Task(Long id, Level level, LocalDate deadline, LocalDate createDate, String content, Person person) {
        this.id = id;
        this.level = level;
        this.deadline = deadline;
        this.createDate = createDate;
        this.content = content;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", level=" + level +
                ", deadline=" + deadline +
                ", crateDate=" + createDate +
                ", content='" + content + '\'' +
                ", person=" + person +
                '}';
    }
}


