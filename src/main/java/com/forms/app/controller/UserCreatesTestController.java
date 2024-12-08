package com.forms.app.controller;

import com.forms.app.model.UserCreatesTest;
import com.forms.app.model.UserCreatesTestId;
import com.forms.app.service.UserCreatesTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/userCreatesTests")
public class UserCreatesTestController {

    private final UserCreatesTestService service;

    @Autowired
    public UserCreatesTestController(UserCreatesTestService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void createUserCreatesTest(@RequestBody UserCreatesTest creation) {
        service.newCreation(creation);
    }

    @DeleteMapping("/")
    public void deleteUserCreatesTest(@RequestBody UserCreatesTestId id) {
        service.deleteCreation(id);
    }

    @GetMapping("/")
    public Optional<UserCreatesTest> findUserCreatesTestById(@RequestBody UserCreatesTestId id) {
        return service.findCreationById(id);
    }

    @GetMapping("/all")
    public List<UserCreatesTest> findAllUserCreatesTests() {
        return service.findAll();
    }
}
