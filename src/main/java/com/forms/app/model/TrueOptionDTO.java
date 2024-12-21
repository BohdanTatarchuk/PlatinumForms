package com.forms.app.model;

public class TrueOptionDTO {
    private String id;
    private boolean correct;
    private String text;
    private Question question;

    public TrueOptionDTO(String id, boolean correct, String text, Question question) {
        this.id = id;
        this.correct = correct;
        this.text = text;
        this.question = question;
    }

    public TrueOptionDTO() {
    }

    public Question getQuestionId() {
        return question;
    }

    public void setQuestionId(Question question) {
        this.question = question;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
