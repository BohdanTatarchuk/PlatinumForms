package com.forms.app.controller;

import com.forms.app.model.QuestionContainsOption;
import com.forms.app.model.QuestionContainsOptionId;
import com.forms.app.service.QuestionContainsOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/questionContainsOptions")
public class QuestionContainsOptionController {

    private final QuestionContainsOptionService service;

    @Autowired
    public QuestionContainsOptionController(QuestionContainsOptionService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void save(@RequestBody QuestionContainsOption relation) {
        service.createQuestionContainsOption(relation);
    }

    @GetMapping("/")
    public Optional<QuestionContainsOption> findById(@RequestBody QuestionContainsOptionId id) {
        return service.findById(id);
    }

    @GetMapping("/all")
    public List<QuestionContainsOption> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/")
    public void deleteQuestionContainsOptionById(@RequestBody QuestionContainsOptionId id) {
        service.deleteQuestionContainsOptionById(id);
    }
}
