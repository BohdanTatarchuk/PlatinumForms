package com.forms.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "UserCreatesTest")
public class UserCreatesTest {

    @Id
    private String user_id;

    @Id
    private String test_id;

    private Date createdOn;

}
