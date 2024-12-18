package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TestExemplar")
public class TestExemplar {
    @Column(name = "overallMark")
    private float overallMark;

    @Id
    @OneToOne
    @JoinColumn(name = "testForm", referencedColumnName = "test_id")
    private TestForm testForm;

    public TestExemplar() {}

    public TestExemplar(float overallMark, TestForm testForm) {
        this.overallMark = overallMark;
        this.testForm = testForm;
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
    }
}
