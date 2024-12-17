package com.forms.app.controller;

import com.forms.app.model.QuestionOption;
import com.forms.app.service.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/options")
public class QuestionOptionController {

    QuestionOptionService service;

    @Autowired
    public QuestionOptionController(QuestionOptionService service){
        this.service = service;
    }

    @GetMapping("/question/{questionId}")
    public List<QuestionOption> findAllOptions(@PathVariable("questionId") String questionId) {
        return service.findAllForQuestion(questionId);
    }

    @GetMapping("/{optionId}")
    public Optional<QuestionOption> findById(@PathVariable("optionId") String optionId) {
        return service.findOneSpecific(optionId);
    }

    @PostMapping("/")
    public void save(@RequestBody QuestionOption option) {
        service.saveOption(option);
    }

    @PutMapping("/{optionId}")
    public void updateOption(@PathVariable("optionId") String optionId, @RequestBody QuestionOption option) {
        service.updateOption(optionId, option);
    }

    @DeleteMapping("/{option_id}")
    public void deleteById(@PathVariable("option_id") String optionId) {
        service.deleteOption(optionId);
    }
}
