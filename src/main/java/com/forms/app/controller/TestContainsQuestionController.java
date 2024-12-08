package com.forms.app.controller;

import com.forms.app.model.TestContainsQuestion;
import com.forms.app.model.TestContainsQuestionId;
import com.forms.app.service.TestContainsQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/testContainsQuestions")
public class TestContainsQuestionController {

    private final TestContainsQuestionService service;

    @Autowired
    public TestContainsQuestionController(TestContainsQuestionService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void createRelation(@RequestBody TestContainsQuestion relation) {
        service.createTestContainsQuestion(relation);
    }

    @GetMapping("/")
    public Optional<TestContainsQuestion> findById(@RequestBody TestContainsQuestionId id) {
        return service.findById(id);
    }

    @DeleteMapping("/")
    public void deleteRelation(@RequestBody TestContainsQuestionId id) {
        service.deleteTestContainsQuestionById(id);
    }

    @GetMapping("/all")
    public List<TestContainsQuestion> findAll() {
        return service.findAll();
    }
}
