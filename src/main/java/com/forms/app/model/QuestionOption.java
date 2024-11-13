package com.forms.app.model;

public class QuestionOption {

    private String text;

    private String id;

    private boolean correct;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public QuestionOption(String text, String id, boolean correct) {
        this.text = text;
        this.id = id;
        this.correct = correct;
    }
}
