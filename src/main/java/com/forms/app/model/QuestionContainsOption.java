package com.forms.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "QuestionContainsOption")
public class QuestionContainsOption {

    @Id
    private String question_id;

    @Id
    private String option_id;
}
//卍 ZOV 卍