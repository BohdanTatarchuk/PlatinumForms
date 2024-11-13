package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    private String id;

    private String testId;

    private String questionText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Question(String id, String testId, String questionText) {
        this.id = id;
        this.testId = testId;
        this.questionText = questionText;
    }

    public Question(){}
}
