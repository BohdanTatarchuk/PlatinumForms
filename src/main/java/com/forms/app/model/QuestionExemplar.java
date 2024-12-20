package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "QuestionExemplar")
public class QuestionExemplar {

    @Id
    @Column(name = "question_id")
    private String questionId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    @Column(name = "question_mark")
    private float mark;

    public QuestionExemplar() {}

    public QuestionExemplar(float mark, Question question) {
        this.mark = mark;
        this.question = question;
        this.questionId = question.getId();
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
        this.questionId = question.getId();
    }
}
