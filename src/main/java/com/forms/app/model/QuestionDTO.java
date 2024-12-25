package com.forms.app.model;

import java.util.List;

public class QuestionDTO {
    private String text;
    private int type;
    private String id;
    private TestForm test;
    private boolean obligatory;
    private List<QuestionOption> options;

    public QuestionDTO(String text, int type, String id, TestForm test, boolean obligatory, List<QuestionOption> options) {
        this.text = text;
        this.type = type;
        this.id = id;
        this.test = test;
        this.obligatory = obligatory;
        this.options = options;
    }

    public QuestionDTO() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestForm getTest() {
        return test;
    }

    public void setTest(TestForm test) {
        this.test = test;
    }

    public boolean isObligatory() {
        return obligatory;
    }

    public void setObligatory(boolean obligatory) {
        this.obligatory = obligatory;
    }

    public List<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOption> options) {
        this.options = options;
    }
}
