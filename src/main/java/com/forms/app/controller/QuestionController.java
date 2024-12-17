package com.forms.app.controller;

import com.forms.app.model.Question;
import com.forms.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service){
        this.service = service;
    }

    @GetMapping("/{questionId}")
    public Optional<Question> findById(@PathVariable("questionId") String questionId) {
        return service.findOneSpecific(questionId);
    }

    @GetMapping("/test/{testId}")
    public List<Question> findAllQuestions(@PathVariable("testId") String testId) {
        return service.findAllForTest(testId);
    }

    @PostMapping("/")
    public void save(@RequestBody Question question) {
        service.createQuestion(question);
    }

    @PutMapping("/{id}")
    public void updateQuestionById(@PathVariable("id") String id, @RequestBody Question q) {
        service.updateQuestion(id, q);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        service.deleteQuestionById(id);
    }
}
