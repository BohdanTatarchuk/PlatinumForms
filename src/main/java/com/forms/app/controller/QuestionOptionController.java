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

    @GetMapping("/")
    public List<QuestionOption> findAllOptions() {
        return service.findAllOptions();
    }

    @GetMapping("/{option_id}")
    public Optional<QuestionOption> findById(@PathVariable("option_id") String optionId) {
        return service.findById(optionId);
    }

    @PostMapping("/")
    public void save(@RequestBody QuestionOption option) {
        service.createOption(option);
    }

    @PutMapping("/{option_id}")
    public void updateOption(@PathVariable("option_id") String optionId, @RequestBody QuestionOption option) {
        service.updateQuestionOption(optionId, option);
    }

    @DeleteMapping("/{option_id}")
    public void deleteById(@PathVariable("option_id") String optionId) {
        service.deleteQuestionById(optionId);
    }
}
