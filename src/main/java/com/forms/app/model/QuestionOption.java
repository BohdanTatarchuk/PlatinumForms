package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "QuestionOption")
public class QuestionOption {

    @Id
    private String option_id;

    @Column(length = 100)
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    private boolean correct;

    public QuestionOption() {}

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return option_id;
    }

    public void setId(String id) {
        this.option_id = id;
    }

    public boolean getIsCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public QuestionOption(String text, String id, boolean correct) {
        this.text = text;
        this.option_id = id;
        this.correct = correct;
    }
}
