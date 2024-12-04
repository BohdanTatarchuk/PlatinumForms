package com.forms.app.controller;

import com.forms.app.model.TestForm;
import com.forms.app.service.TestFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/tests/")
public class TestFromController {

    private final TestFormService service;

    @Autowired
    public TestFromController(TestFormService service){
        this.service = service;
    }

    @GetMapping("{testID}")
    public Optional<TestForm> findByTestID(@PathVariable("testID") String testID) {
        return service.findByTestID(testID);
    }

    @PostMapping("save")
    public void save(@RequestBody TestForm testForm) {
        service.createTestForm(testForm);
    }

    @PutMapping("updateName={testID}")
    public void updateTestName(@PathVariable("testID") String testID, @RequestBody String newTestName) {
        service.updateTestName(testID, newTestName);
    }

    @PutMapping("updateDescription={testID}")
    public void updateTestDescription(@PathVariable("testID") String testID, @RequestBody String newDescription) {
        service.updateTestDescription(testID, newDescription);
    }

    @DeleteMapping("deleteByTestID={testID}")
    public void deleteByTestID(@PathVariable("testID") String testID) {
        service.deleteTestForm(testID);
    }
}
