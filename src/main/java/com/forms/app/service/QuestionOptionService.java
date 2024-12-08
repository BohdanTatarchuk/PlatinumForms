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

    public void createOption(QuestionOption option) {
        questionOptionRepository.save(option);
    }

    public Optional<QuestionOption> findById(String option_id) {
        return questionOptionRepository.findById(option_id);
    }

    public void updateQuestionOption(String option_id, QuestionOption option) {
        if (questionOptionRepository.findById(option_id).isEmpty()) {
            System.out.println("Error: User with login " + option_id + " not found");
            return;
        }

        QuestionOption newOption = questionOptionRepository.findById(option_id).get();
        newOption.setText(option.getText());
        newOption.setCorrect(option.getIsCorrect());
        questionOptionRepository.save(newOption);
    }


    public void deleteQuestionById(String id) {
        questionOptionRepository.deleteById(id);
    }

    public List<QuestionOption> findAllOptions() {
        return questionOptionRepository.findAll();
    }
}
