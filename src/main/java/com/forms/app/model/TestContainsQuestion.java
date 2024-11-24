package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TestContainsQuestion")
public class TestContainsQuestion {

    @EmbeddedId
    private TestContainsQuestionId id;

    @ManyToOne
    @MapsId("test_id")
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private TestForm testForm;

    @ManyToOne
    @MapsId("question_id")
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    public TestContainsQuestion(Question question, TestForm testForm, TestContainsQuestionId id) {
        this.question = question;
        this.testForm = testForm;
        this.id = id;
    }

    public TestContainsQuestion() {
    }

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }

    public TestContainsQuestionId getId() {
        return id;
    }

    public void setId(TestContainsQuestionId id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
