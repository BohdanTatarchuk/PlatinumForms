package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserPassesTest")
public class UserPassesTest {

    @EmbeddedId
    private UserPassesTestId id;

    @ManyToOne
    @MapsId("email")
    @JoinColumn(name = "email", referencedColumnName = "email")
    private UserT user;

    @ManyToOne
    @MapsId("test_id")
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private TestForm testform;

    private float mark;

    public UserPassesTest(UserPassesTestId id, UserT user, TestForm testform, int mark) {
        this.id = id;
        this.user = user;
        this.testform = testform;
        this.mark = mark;
    }

    public UserPassesTest() {}

    public UserPassesTestId getId() {
        return id;
    }

    public void setId(UserPassesTestId id) {
        this.id = id;
    }

    public UserT getUser() {
        return user;
    }

    public void setUser(UserT user) {
        this.user = user;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public TestForm getTestform() {
        return testform;
    }

    public void setTestform(TestForm testform) {
        this.testform = testform;
    }
}
