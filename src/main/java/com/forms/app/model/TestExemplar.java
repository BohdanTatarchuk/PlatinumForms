package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TestExemplar")
public class TestExemplar {

    @Id
    @Column(name = "testForm") // Primary key column
    private String testFormId;

    @OneToOne
    @MapsId // Maps testFormId as both primary key and foreign key
    @JoinColumn(name = "testForm", referencedColumnName = "test_id")
    private TestForm testForm;

    @Column(name = "overallMark")
    private float overallMark;

    public TestExemplar() {}

    public TestExemplar(float overallMark, TestForm testForm) {
        this.overallMark = overallMark;
        this.testForm = testForm;
        this.testFormId = testForm.getId(); // Set the primary key
    }

    public float getOverallMark() {
        return overallMark;
    }

    public void setOverallMark(float overallMark) {
        this.overallMark = overallMark;
    }

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
        this.testFormId = testForm.getId();
    }
}
