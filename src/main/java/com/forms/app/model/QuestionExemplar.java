package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "QuestionExemplar")
public class QuestionExemplar {
    @Column(name = "question_mark")
    private float mark;

    @Id
    @OneToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    public QuestionExemplar() {}

    public QuestionExemplar(float mark, Question question) {
        this.mark = mark;
        this.question = question;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
