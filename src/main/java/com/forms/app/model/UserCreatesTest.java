package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "UserCreatesTest")
public class UserCreatesTest {

    @EmbeddedId
    private UserCreatesTestId id;

    @ManyToOne
    @MapsId("email")
    @JoinColumn(name = "email", referencedColumnName = "email")
    private UserT user;

    @ManyToOne
    @MapsId("test_id")
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    private TestForm testform;

    public UserCreatesTest(UserCreatesTestId id, UserT user, TestForm testform) {
        this.id = id;
        this.user = user;
        this.testform = testform;
    }

    public UserCreatesTest() {
    }

    public UserCreatesTestId getId() {
        return id;
    }

    public void setId(UserCreatesTestId id) {
        this.id = id;
    }

    public UserT getUser() {
        return user;
    }

    public void setUser(UserT user) {
        this.user = user;
    }

    public TestForm getTestform() {
        return testform;
    }

    public void setTestform(TestForm testform) {
        this.testform = testform;
    }
}
