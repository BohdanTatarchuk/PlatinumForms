package com.forms.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @Column(name = "question_id")
    private String question_id;

    @Column(length = 100)
    private String questionText;

    private int questionType;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @JsonIgnore
    private TestForm test;

    private boolean isObligatory;

    public Question(String id, String questionText, boolean isObligatory) {
        this.question_id = id;
        this.questionText = questionText;
        this.isObligatory = isObligatory;
    }

    public Question() {
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public boolean isObligatory() {
        return isObligatory;
    }

    public void setObligatory(boolean obligatory) {
        isObligatory = obligatory;
    }

    public TestForm getTest() {
        return test;
    }

    public void setTest(TestForm test) {
        this.test = test;
    }

    public String getId() {
        return question_id;
    }

    public void setId(String id) {
        this.question_id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
