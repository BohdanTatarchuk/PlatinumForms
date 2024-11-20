package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @Column(name = "question_id")
    private String id;

    private String questionText;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Question(String id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public Question(){}
}
