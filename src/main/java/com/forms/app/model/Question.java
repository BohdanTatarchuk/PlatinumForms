package com.forms.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @Column(name = "question_id")
    private String question_id;

    @Column(length = 100)
    private String questionText;

    private boolean isObligatory;

    public Question(String id, String questionText, boolean isObligatory) {
        this.question_id = id;
        this.questionText = questionText;
        this.isObligatory = isObligatory;
    }

    public Question() {
    }

    public boolean isObligatory() {
        return isObligatory;
    }

    public void setObligatory(boolean obligatory) {
        isObligatory = obligatory;
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
