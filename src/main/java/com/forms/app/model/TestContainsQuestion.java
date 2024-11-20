package com.forms.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TestContainsQuestion")
public class TestContainsQuestion {

    @Id
    private String test_id;

    @Id
    private String question_id;
}
