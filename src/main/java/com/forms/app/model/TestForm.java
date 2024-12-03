package com.forms.app.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TestForm")
public class TestForm {

    @Column(length = 100)
    private String name;

    private String description;

    @Id
    @Column(name = "test_id")
    private String test_id;

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

    public TestForm(String name, String description, String id) {
        this.name = name;
        this.description = description;
        this.test_id = id;
    }

    public TestForm(){}
}
