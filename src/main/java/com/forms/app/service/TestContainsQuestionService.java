package com.forms.app.service;

import com.forms.app.model.QuestionContainsOption;
import com.forms.app.model.QuestionContainsOptionId;
import com.forms.app.model.TestContainsQuestion;
import com.forms.app.model.TestContainsQuestionId;
import com.forms.app.repository.TestContainsQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestContainsQuestionService {

    private final TestContainsQuestionRepository testContainsQuestionRepository;

    @Autowired
    public TestContainsQuestionService(TestContainsQuestionRepository testContainsQuestionRepository) {
        this.testContainsQuestionRepository = testContainsQuestionRepository;
    }

    public void createTestContainsQuestion(TestContainsQuestion q) {
        testContainsQuestionRepository.save(q);
    }

    public Optional<TestContainsQuestion> findById(TestContainsQuestionId id) {
        return testContainsQuestionRepository.findById(id);
    }

    public void deleteTestContainsQuestionById(TestContainsQuestionId id) {
        testContainsQuestionRepository.deleteById(id);
    }

    public List<TestContainsQuestion> findAll(){
        return testContainsQuestionRepository.findAll();
    }
}
