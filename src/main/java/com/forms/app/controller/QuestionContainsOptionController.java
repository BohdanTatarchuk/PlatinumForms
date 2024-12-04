package com.forms.app.controller;

import com.forms.app.service.QuestionContainsOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/questionContainsOptions/")
public class QuestionContainsOptionController {

    private final QuestionContainsOptionService service;

    @Autowired
    public QuestionContainsOptionController(QuestionContainsOptionService service) {
        this.service = service;
    }

}
