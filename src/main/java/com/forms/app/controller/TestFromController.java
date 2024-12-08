package com.forms.app.controller;

import com.forms.app.model.TestForm;
import com.forms.app.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tests")
public class TestFromController {

    private final TestFormService service;

    @Autowired
    public TestFromController(TestFormService service){
        this.service = service;
    }

    @GetMapping("/{testID}")
    public Optional<TestForm> findByTestID(@PathVariable("testID") String testID) {
        return service.findByTestID(testID);
    }

    @GetMapping("/")
    public List<TestForm> findByAllTests() {
        return service.findAllTests();
    }

    @PostMapping("/")
    public void save(@RequestBody TestForm testForm) {
        service.createTestForm(testForm);
    }

    @PutMapping("/{testID}")
    public void updateTest(@PathVariable("testID") String testID, @RequestBody TestForm testForm) {
        service.updateTest(testID, testForm);
    }

    @DeleteMapping("/{testID}")
    public void deleteByTestID(@PathVariable("testID") String testID) {
        service.deleteTestForm(testID);
    }
}
