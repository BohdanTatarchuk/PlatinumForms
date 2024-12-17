package com.forms.app.service;

import com.forms.app.model.QuestionOption;
import com.forms.app.repository.QuestionOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionOptionService {

    private final QuestionOptionRepository questionOptionRepository;

    @Autowired
    public QuestionOptionService(QuestionOptionRepository questionOptionRepository) {
        this.questionOptionRepository = questionOptionRepository;
    }

    public void saveOption(QuestionOption option) {
        questionOptionRepository.save(option);
    }

    public Optional<QuestionOption> findOneSpecific(String option_id) {
        return questionOptionRepository.findById(option_id);
    }

    public void updateOption(String optionId, QuestionOption option) {
        if (questionOptionRepository.findById(optionId).isEmpty()) {
            System.out.println("Error: option not found");
            return;
        }

        QuestionOption newOption = questionOptionRepository.findById(optionId).get();
        newOption.setText(option.getText());
        newOption.setCorrect(option.getIsCorrect());
        questionOptionRepository.save(newOption);
    }

    public List<QuestionOption> findAllForQuestion(String questionId) {
        return questionOptionRepository.findAllForOneQuestion(questionId);
    }

    public void deleteOption(String optionId) {
        questionOptionRepository.deleteById(optionId);
    }
}
