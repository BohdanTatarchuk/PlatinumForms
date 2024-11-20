package com.forms.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserPassesTest")
public class UserPassesTest {

    @Id
    private String user_id;

    @Id
    private String test_id;

    private float mark;

}
