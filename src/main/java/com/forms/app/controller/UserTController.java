package com.forms.app.controller;

import com.forms.app.model.UserT;
import com.forms.app.service.UserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserTController {

    private final UserTService service;

    @Autowired
    public UserTController(UserTService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<UserT> findAll() {
        return service.findAllUsers();
    }

    @GetMapping("/{email}")
    public Optional<UserT> findByLogin(@PathVariable("email") String email) {
        return service.findById(email);
    }

    @DeleteMapping("/{login}")
    public void deleteByLogin(@PathVariable("login") String login) {
        service.deleteUser(login);
    }

    @PostMapping("/")
    public void save(@RequestBody UserT user) {
        service.createUser(user);
    }

    @PutMapping("/{email}")
    public void updateProfilePicture(@PathVariable("email") String email, @RequestBody UserT user) {
        service.updateUser(email, user);
    }
}
