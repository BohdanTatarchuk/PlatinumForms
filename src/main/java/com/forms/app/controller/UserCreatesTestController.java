package com.forms.app.controller;

import com.forms.app.service.UserCreatesTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/userCreatesTest/")
public class UserCreatesTestController {

    private final UserCreatesTestService service;

    @Autowired
    public UserCreatesTestController(UserCreatesTestService service){
        this.service = service;
    }
}
