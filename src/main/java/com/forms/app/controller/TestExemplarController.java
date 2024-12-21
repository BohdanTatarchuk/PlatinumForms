package com.forms.app.controller;

import com.forms.app.model.TestExemplar;
import com.forms.app.service.TestExemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/testExemplars")
public class TestExemplarController {
    private final TestExemplarService service;

    @Autowired
    public TestExemplarController(TestExemplarService service) {
        this.service = service;
    }

    @GetMapping("/exemplar/{test_id}")
    public Optional<TestExemplar> getTestExemplar(@PathVariable("test_id") String test_id) {
        return service.findExemplar(test_id);
    }

    //TODO: get test exemplars for a specific user
    @GetMapping("/")
    public List<TestExemplar> getTestExemplars() {
        return service.findAllExemplars();
    }

    @PostMapping("/")
    public void addTestExemplar(@RequestBody TestExemplar testExemplar) {
        service.saveExemplar(testExemplar);
    }

    @PutMapping("/{test_id}")
    public void updateTestExemplar(@PathVariable("test_id") String test_id, @RequestBody TestExemplar testExemplar) {
        service.updateExemplar(testExemplar, test_id);
    }

    @DeleteMapping("/{test_id}")
    public void deleteTestExemplar(@PathVariable("test_id") String test_id) {
        service.deleteExemplar(test_id);
    }
}

