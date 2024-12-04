package com.forms.app.controller;

import com.forms.app.service.TestContainsQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/testContainsQuestion/")
public class TestContainsQuestionController {

    private final TestContainsQuestionService service;

    @Autowired
    public TestContainsQuestionController(TestContainsQuestionService service){
        this.service = service;
    }
}
