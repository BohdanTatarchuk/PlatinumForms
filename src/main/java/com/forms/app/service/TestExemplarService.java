package com.forms.app.service;

import com.forms.app.model.TestExemplar;
import com.forms.app.repository.TestExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestExemplarService {
    private final TestExemplarRepository repository;

    @Autowired
    public TestExemplarService(TestExemplarRepository repository) {
        this.repository = repository;
    }

    public void saveExemplar(TestExemplar testExemplar) {
        repository.save(testExemplar);
    }

    public void updateExemplar(TestExemplar testExemplar, String test_id) {
        Optional<TestExemplar> optional = repository.findById(test_id);
        TestExemplar newTest;
        if (optional.isPresent()) {
            newTest = optional.get();
            newTest.setTestForm(testExemplar.getTestForm());
            newTest.setOverallMark(testExemplar.getOverallMark());
            repository.save(newTest);
        }
    }

    public List<TestExemplar> findAllExemplars() {
        return repository.findAll();
    }

    public Optional<TestExemplar> findExemplar(String test_id) {
        return repository.findById(test_id);
    }

    public void deleteExemplar(String test_id) {
        repository.deleteById(test_id);
    }
}
