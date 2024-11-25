package com.forms.app.service;

import com.forms.app.model.QuestionContainsOption;
import com.forms.app.model.QuestionContainsOptionId;
import com.forms.app.repository.QuestionContainsOptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionContainsOptionService {

    private final QuestionContainsOptionRepository questionContainsOptionRepository;

    public QuestionContainsOptionService(QuestionContainsOptionRepository questionContainsOptionRepository) {
        this.questionContainsOptionRepository = questionContainsOptionRepository;
    }

    public void createQuestionContainsOption(QuestionContainsOption q) {
        questionContainsOptionRepository.save(q);
    }

    public Optional<QuestionContainsOption> findById(QuestionContainsOptionId id) {
        return questionContainsOptionRepository.findById(id);
    }

    public void deleteQuestionContainsOptionById(QuestionContainsOptionId id) {
        questionContainsOptionRepository.deleteById(id);
    }
}
