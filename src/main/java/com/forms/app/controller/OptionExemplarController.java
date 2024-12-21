package com.forms.app.controller;

import com.forms.app.model.OptionExemplar;
import com.forms.app.service.OptionExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/optionExemplars")
public class OptionExemplarController {
    private final OptionExemplarService service;

    @Autowired
    public OptionExemplarController(OptionExemplarService service) {
        this.service = service;
    }

    @GetMapping("/exemplar/{option_id}")
    public Optional<OptionExemplar> getOptionExemplar(@PathVariable("option_id") String option_id) {
        return service.findSpecific(option_id);
    }

    //TODO: get option exemplars for a specific question
    @GetMapping("/")
    public List<OptionExemplar> getOptionExemplars() {
        return service.findAllExemplars();
    }

    @PostMapping("/")
    public void addOptionExemplar(@RequestBody OptionExemplar OptionExemplar) {
        service.saveExemplar(OptionExemplar);
    }

    @PutMapping("/{option_id}")
    public void updateOptionExemplar(@PathVariable("option_id") String option_id, @RequestBody OptionExemplar OptionExemplar) {
        service.updateExemplar(OptionExemplar, option_id);
    }

    @DeleteMapping("/{option_id}")
    public void deleteOptionExemplar(@PathVariable("option_id") String option_id) {
        service.deleteExemplar(option_id);
    }
}

