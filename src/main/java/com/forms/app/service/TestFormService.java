package com.forms.app.service;

import com.forms.app.model.TestForm;
import com.forms.app.repository.TestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestFormService {

    private final TestFormRepository testFormRepository;

    @Autowired
    public TestFormService(TestFormRepository testFormRepository) {
        this.testFormRepository = testFormRepository;
    }

    public void createTestForm(TestForm testForm) {
        testFormRepository.save(testForm);
    }

    public Optional<TestForm> findByTestID(String testID) {
        return testFormRepository.findById(testID);
    }

    public void updateTestName(String testID, String newTestName) {
        Optional<TestForm> testForm = testFormRepository.findById(testID);

        if (testForm.isPresent()) {
            testForm.get().setName(newTestName);
            testFormRepository.save(testForm.get());
        }
    }

    public void updateTestDescription(String testID, String newDescription) {
        Optional<TestForm> testForm = testFormRepository.findById(testID);

        if (testForm.isPresent()) {
            testForm.get().setDescription(newDescription);
            testFormRepository.save(testForm.get());
        }
    }

    public void deleteTestForm(String testID) {
        testFormRepository.deleteById(testID);
    }
}
