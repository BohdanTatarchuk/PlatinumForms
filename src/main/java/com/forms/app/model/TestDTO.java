package com.forms.app.model;

import java.util.List;

public class TestDTO {
    private String name;
    private String description;
    private String id;
    private UserT authorEmail;
    private List<QuestionDTO> questions;

    public TestDTO(String name, String description, String id, UserT authorEmail, List<QuestionDTO> questions) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.authorEmail = authorEmail;
        this.questions = questions;
    }

    public TestDTO() {
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserT getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(UserT authorEmail) {
        this.authorEmail = authorEmail;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
