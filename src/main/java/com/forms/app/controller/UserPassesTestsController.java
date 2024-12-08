package com.forms.app.controller;

import com.forms.app.model.UserPassesTest;
import com.forms.app.model.UserPassesTestId;
import com.forms.app.service.UserPassesTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/userPassesTests")
public class UserPassesTestsController {

    private final UserPassesTestService service;

    @Autowired
    public UserPassesTestsController(UserPassesTestService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void createUserPass(@RequestBody UserPassesTest pass) {
        service.createNewPass(pass);
    }

    @GetMapping("/")
    public Optional<UserPassesTest> findPassById(@RequestBody UserPassesTestId id) {
        return service.findPassByID(id);
    }

    @PutMapping("/")
    public void updateUserPassMark(@RequestBody UserPassesTestId id, @RequestParam("newMark") float newMark) {
        service.updateMark(id, newMark);
    }

    @DeleteMapping("/")
    public void deleteUserPass(@RequestBody UserPassesTestId id) {
        service.deletePass(id);
    }

    @GetMapping("/all")
    public List<UserPassesTest> findAllUserPassesTests() {
        return service.findAll();
    }
}
