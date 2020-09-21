package com.example.model;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Future;
import java.util.Calendar;
import java.util.Date;

@Entity
@SQLDelete(sql = "update task set deleted = true where id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
public class Task extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private Level level;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal( TemporalType.DATE )
    @Future
    private Date deadline;
    @Lob
    private String content;
    private boolean deleted;
    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name="person_id")
    private Person person;

    public Task() {
    }

    public Task(Level level, Date deadline, String content, Person person) {
        this.level = level;
        this.deadline = deadline;
        this.content = content;
        this.person = person;
    }

    public Task(Long id, Date createDate, Level level, Date deadline, String content, Person person) {
        super(id,createDate);
        this.level = level;
        this.deadline = deadline;
        this.content = content;
        this.person = person;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "level=" + level +
                ", deadline=" + deadline +
                ", content='" + content + '\'' +
                ", person=" + person +
                "} " + super.toString();
    }
}


