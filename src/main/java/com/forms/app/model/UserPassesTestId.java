package com.forms.app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserPassesTestId {

    private String email;

    private String test_id;

    public UserPassesTestId(String email, String test_id) {
        this.email = email;
        this.test_id = test_id;
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
}
