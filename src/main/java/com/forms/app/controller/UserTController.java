package com.forms.app.controller;

import com.forms.app.model.UserT;
import com.forms.app.service.UserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/users/")
public class UserTController {

    private final UserTService service;

    @Autowired
    public UserTController(UserTService service) {
        this.service = service;
    }

    @GetMapping("{email}")
    public Optional<UserT> findByLogin(@PathVariable("email") String email) {
        return service.findById(email);
    }

    @DeleteMapping("deleteByLogin={login}")
    public void deleteByLogin(@PathVariable("login") String login) {
        service.deleteUser(login);
    }

    @PostMapping("save")
    public void save(@RequestBody UserT user) {
        service.createUser(user);
    }

    @PutMapping("updateProfilePicture={email}")
    public void updateProfilePicture(@PathVariable("email") String email, @RequestBody String picture) {
        service.updateProfilePicture(email, picture);
    }

    @PutMapping("updateUsername={email}")
    public void updateUsername(@PathVariable("email") String email, @RequestBody String username) {
        service.updateUsername(email, username);
    }
}
