package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TestForm")
public class TestForm {

    @Column(length = 100)
    private String name;

    private String description;

    @Id
    @Column(name = "test_id")
    private String test_id;

    @ManyToOne
    @JoinColumn(name = "authorEmail", referencedColumnName = "email")
    private UserT author;

    public UserT getAuthorEmail() {
        return author;
    }

    public void setAuthorEmail(UserT author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return test_id;
    }

    public void setId(String id) {
        this.test_id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TestForm(String name, String description, String id, UserT author) {
        this.name = name;
        this.description = description;
        this.test_id = id;
        this.author = author;
    }

    public TestForm(){}
}
