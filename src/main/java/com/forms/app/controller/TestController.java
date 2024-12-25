package com.forms.app.controller;

import com.forms.app.model.TestForm;
import com.forms.app.model.TestDTO;
import com.forms.app.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/tests")
public class TestController {

    private final TestService service;

    @Autowired
    public TestController(TestService service){
        this.service = service;
    }

    @GetMapping("/test/{test_id}")
    public TestDTO findTestByTestID(@PathVariable("test_id") String testID) {
        return service.findTest(testID);
    }

    @GetMapping("/{email}")
    public List<TestForm> findAllByEmail(@PathVariable("email") String email) {
        return service.findAllByEmail(email);
    }

    @PostMapping("/")
    public void saveNewTest(@RequestBody TestDTO testForm) {
        service.createTestForm(testForm);
    }

    @DeleteMapping("/{testID}")
    public void deleteByTestID(@PathVariable("testID") String testID) {
        service.deleteTestForm(testID);
    }
}
