package com.forms.app.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TestContainsQuestionId implements Serializable {

    private String test_id;

    private String question_id;

    public TestContainsQuestionId(String test_id, String question_id) {
        this.test_id = test_id;
        this.question_id = question_id;
    }

    public TestContainsQuestionId() {
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }
}
