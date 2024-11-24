package com.forms.app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPassesTestId {

    private String email;

    private String test_id;

    private float mark;

    public UserPassesTestId(String email, String test_id, float mark) {
        this.email = email;
        this.test_id = test_id;
        this.mark = mark;
    }

    public UserPassesTestId() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
