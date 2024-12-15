package com.forms.app.service;

import com.forms.app.model.TestForm;
import com.forms.app.repository.TestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<TestForm> findByEmail(String email, String testID) {
        return testFormRepository.findByEmail(email, testID);
    }

    public List<TestForm> findAllByEmail(String email) {
        return testFormRepository.findAllByEmail(email);
    }

    public void updateTest(String testID, TestForm testForm) {
        Optional<TestForm> foundTestForm = testFormRepository.findById(testID);

        if (foundTestForm.isPresent()) {
            foundTestForm.get().setDescription(testForm.getDescription());
            foundTestForm.get().setName(testForm.getName());
            testFormRepository.save(foundTestForm.get());
        }
    }

    public void deleteTestForm(String testID) {
        testFormRepository.deleteById(testID);
    }
}
