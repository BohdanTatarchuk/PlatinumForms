package com.forms.app.service;

import com.forms.app.model.QuestionContainsOption;
import com.forms.app.model.QuestionContainsOptionId;
import com.forms.app.repository.QuestionContainsOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionContainsOptionService {

    private final QuestionContainsOptionRepository questionContainsOptionRepository;

    @Autowired
    public QuestionContainsOptionService(QuestionContainsOptionRepository questionContainsOptionRepository) {
        this.questionContainsOptionRepository = questionContainsOptionRepository;
    }

    public void createQuestionContainsOption(QuestionContainsOption q) {
        questionContainsOptionRepository.save(q);
    }

    public Optional<QuestionContainsOption> findById(QuestionContainsOptionId id) {
        return questionContainsOptionRepository.findById(id);
    }

    public List<QuestionContainsOption> findAll(){
        return questionContainsOptionRepository.findAll();
    }

    public void deleteQuestionContainsOptionById(QuestionContainsOptionId id) {
        questionContainsOptionRepository.deleteById(id);
    }
}
