package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "QuestionContainsOption")
public class QuestionContainsOption {

    @EmbeddedId
    private QuestionContainsOptionId id;

    @ManyToOne
    @MapsId("question_id")
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;

    @ManyToOne
    @MapsId("option_id")
    @JoinColumn(name = "option_id", referencedColumnName = "option_id")
    private QuestionOption option;

    public QuestionContainsOption() {
    }

    public QuestionContainsOption(QuestionContainsOptionId id, Question question, QuestionOption option) {
        this.id = id;
        this.question = question;
        this.option = option;
    }

    public QuestionContainsOptionId getId() {
        return id;
    }

    public void setId(QuestionContainsOptionId id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public QuestionOption getOption() {
        return option;
    }

    public void setOption(QuestionOption option) {
        this.option = option;
    }
}
