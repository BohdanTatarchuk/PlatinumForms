package com.forms.app.controller;

import com.forms.app.service.UserPassesTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/userPassesTests/")
public class UserPassesTestsController {

    private final UserPassesTestService service;

    @Autowired
    public UserPassesTestsController(UserPassesTestService service){
        this.service = service;
    }
}
