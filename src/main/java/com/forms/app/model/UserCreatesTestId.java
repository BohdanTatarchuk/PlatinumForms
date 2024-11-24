package com.forms.app.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class UserCreatesTestId implements Serializable {

    private String email;

    private String test_id;

    private Date createdOn;

    public UserCreatesTestId(String email, String test_id, Date createdOn) {
        this.email = email;
        this.test_id = test_id;
        this.createdOn = createdOn;
    }

    public UserCreatesTestId() {
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
