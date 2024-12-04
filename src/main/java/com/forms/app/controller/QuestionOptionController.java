package com.forms.app.controller;

import com.forms.app.model.QuestionOption;
import com.forms.app.service.QuestionOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/options/")
public class QuestionOptionController {

    QuestionOptionService service;

    @Autowired
    public QuestionOptionController(QuestionOptionService service){
        this.service = service;
    }

    @GetMapping("{option_id}")
    public Optional<QuestionOption> findById(@PathVariable("option_id") String optionId) {
        return service.findById(optionId);
    }

    @PostMapping("save")
    public void save(@RequestBody QuestionOption option) {
        service.createOption(option);
    }

    @PutMapping("updateText={option_id}")
    public void updateOptionText(@PathVariable("option_id") String optionId, @RequestBody String text) {
        service.updateQuestionOptionTextById(optionId, text);
    }

    @PutMapping("updateCorrectness={option_id}")
    public void updateOptionCorrectness(@PathVariable("option_id") String optionId, @RequestBody boolean correct) {
        service.updateQuestionOptionCorrectnessById(optionId, correct);
    }

    @PutMapping("update={option_id}")
    public void updateOption(@PathVariable("option_id") String optionId, @RequestParam("text") String text, @RequestParam("correct") boolean correct) {
        service.updateQuestionOptionById(optionId, text, correct);
    }

    @DeleteMapping("deleteById={option_id}")
    public void deleteById(@PathVariable("option_id") String optionId) {
        service.deleteQuestionById(optionId);
    }
}
