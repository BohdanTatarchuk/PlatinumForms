package com.forms.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserT")
public class UserT {

    @Column(length = 25)
    private String username;

    @Id
    private String email;

    @Column(length = 25)
    private String password;

    @Column(length = 10000)
    private String photo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserT(String username, String email, String password, String photo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public UserT() {}
}
