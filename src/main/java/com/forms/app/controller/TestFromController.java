package com.forms.app.controller;

import com.forms.app.model.TestForm;
import com.forms.app.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/tests")
public class TestFromController {

    private final TestFormService service;

    @Autowired
    public TestFromController(TestFormService service){
        this.service = service;
    }

    @GetMapping("/{email}/{test_id}")
    public Optional<TestForm> findTestByTestID(@PathVariable("email") String email, @PathVariable("test_id") String testID) {
        return service.findByEmail(email, testID);
    }

    @GetMapping("/{email}")
    public List<TestForm> findAllByEmail(@PathVariable("email") String email) {
        return service.findAllByEmail(email);
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
