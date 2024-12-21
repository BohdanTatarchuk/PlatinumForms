package com.forms.app.controller;

import com.forms.app.model.QuestionExemplar;
import com.forms.app.service.QuestionExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/questionExemplars")
public class QuestionExemplarController {
    private final QuestionExemplarService service;

    @Autowired
    public QuestionExemplarController(QuestionExemplarService service) {
        this.service = service;
    }

    @GetMapping("/exemplar/{question_id}")
    public Optional<QuestionExemplar> getQuestionExemplar(@PathVariable("question_id") String question_id) {
        return service.findSpecific(question_id);
    }

    //TODO: get question exemplars for a specific test
    @GetMapping("/")
    public List<QuestionExemplar> getQuestionExemplars() {
        return service.findAllExemplars();
    }

    @PostMapping("/")
    public void addQuestionExemplar(@RequestBody QuestionExemplar QuestionExemplar) {
        service.saveExemplar(QuestionExemplar);
    }

    @PutMapping("/{question_id}")
    public void updateQuestionExemplar(@PathVariable("question_id") String question_id, @RequestBody QuestionExemplar QuestionExemplar) {
        service.updateExemplar(QuestionExemplar, question_id);
    }

    @DeleteMapping("/{question_id}")
    public void deleteQuestionExemplar(@PathVariable("question_id") String question_id) {
        service.deleteExemplar(question_id);
    }
}

