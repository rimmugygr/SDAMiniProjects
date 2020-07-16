package com.example.model;

import javax.persistence.*;

@Entity
public class Person extends BaseEntity {
    private String firstName;
    private String lastName;
    private String github;
    private String start;
    private Integer java;
    private Integer bestpractice;
    private Integer tdd;
    private Integer question;
    private Integer hibernate;
    private Integer html;
    private Integer jsp;
    private Integer thymeleaf;
    private Integer git;
    private Integer checkBox;

    public Person() {
    }

    public Person(String firstName, String lastName, String github, String start) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.github = github;
        this.start = start;
    }

    public Person(Long id, String firstName, String lastName, String github, String start,
                  Integer java, Integer bestpractice, Integer tdd, Integer question,
                  Integer hibernate, Integer html, Integer jsp, Integer thymeleaf,
                  Integer git, Integer checkBox) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.github = github;
        this.start = start;
        this.java = java;
        this.bestpractice = bestpractice;
        this.tdd = tdd;
        this.question = question;
        this.hibernate = hibernate;
        this.html = html;
        this.jsp = jsp;
        this.thymeleaf = thymeleaf;
        this.git = git;
        this.checkBox = checkBox;
    }

    public Integer getJava() {
        return java;
    }

    public void setJava(Integer java) {
        this.java = java;
    }

    public Integer getBestpractice() {
        return bestpractice;
    }

    public void setBestpractice(Integer bestpractice) {
        this.bestpractice = bestpractice;
    }

    public Integer getTdd() {
        return tdd;
    }

    public void setTdd(Integer tdd) {
        this.tdd = tdd;
    }

    public Integer getQuestion() {
        return question;
    }

    public void setQuestion(Integer question) {
        this.question = question;
    }

    public Integer getHibernate() {
        return hibernate;
    }

    public void setHibernate(Integer hibernate) {
        this.hibernate = hibernate;
    }

    public Integer getHtml() {
        return html;
    }

    public void setHtml(Integer html) {
        this.html = html;
    }

    public Integer getJsp() {
        return jsp;
    }

    public void setJsp(Integer jsp) {
        this.jsp = jsp;
    }

    public Integer getThymeleaf() {
        return thymeleaf;
    }

    public void setThymeleaf(Integer thymeleaf) {
        this.thymeleaf = thymeleaf;
    }

    public Integer getGit() {
        return git;
    }

    public void setGit(Integer git) {
        this.git = git;
    }

    public Integer getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Integer checkBox) {
        this.checkBox = checkBox;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", github='" + github + '\'' +
                ", start='" + start + '\'' +
                ", java=" + java +
                ", bestpractice=" + bestpractice +
                ", tdd=" + tdd +
                ", question=" + question +
                ", hibernate=" + hibernate +
                ", html=" + html +
                ", jsp=" + jsp +
                ", thymeleaf=" + thymeleaf +
                ", git=" + git +
                ", checkBox=" + checkBox +
                "} " + super.toString();
    }
}
