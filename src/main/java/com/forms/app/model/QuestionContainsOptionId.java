package com.forms.app.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionContainsOptionId implements Serializable {

    private String question_id;
    private String option_id;

    public QuestionContainsOptionId() {
    }

    public QuestionContainsOptionId(String question_id, String option_id) {
        this.question_id = question_id;
        this.option_id = option_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public String getOption_id() {
        return option_id;
    }

    public void setOption_id(String option_id) {
        this.option_id = option_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionContainsOptionId that = (QuestionContainsOptionId) o;
        return Objects.equals(question_id, that.question_id) && Objects.equals(option_id, that.option_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question_id, option_id);
    }
}
