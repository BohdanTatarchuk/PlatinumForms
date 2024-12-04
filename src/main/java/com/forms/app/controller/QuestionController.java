package com.forms.app.controller;

import com.forms.app.model.Question;
import com.forms.app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/questions/")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service){
        this.service = service;
    }

    @GetMapping("{id}")
    public Optional<Question> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping("save")
    public void save(@RequestBody Question question) {
        service.createQuestion(question);
    }

    @PutMapping("updateText={id}")
    public void updateQuestionById(@PathVariable("id") String id, @RequestBody String text) {
        service.updateQuestionById(id, text);
    }

    @DeleteMapping("deleteById={id}")
    public void deleteById(@PathVariable("id") String id) {
        service.deleteQuestionById(id);
    }
}
