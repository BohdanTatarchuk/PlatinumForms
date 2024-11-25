package com.forms.app.service;

import com.forms.app.model.QuestionOption;
import com.forms.app.repository.QuestionOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updateQuestionOptionTextById(String option_id, String text) {
        if (questionOptionRepository.findById(option_id).isEmpty()) {
            System.out.println("Error: User with login " + option_id + " not found");
            return;
        }

        QuestionOption newOption = questionOptionRepository.findById(option_id).get();
        newOption.setText(text);
        questionOptionRepository.save(newOption);
    }

    public void updateQuestionOptionCorrectnessById(String option_id, boolean correct) {
        if (questionOptionRepository.findById(option_id).isEmpty()) {
            System.out.println("Error: User with login " + option_id + " not found");
            return;
        }

        QuestionOption newOption = questionOptionRepository.findById(option_id).get();
        newOption.setCorrect(correct);
        questionOptionRepository.save(newOption);
    }

    public void updateQuestionOptionById(String option_id, String text, boolean correct) {
        if (questionOptionRepository.findById(option_id).isEmpty()) {
            System.out.println("Error: User with login " + option_id + " not found");
            return;
        }

        QuestionOption newOption = questionOptionRepository.findById(option_id).get();
        newOption.setText(text);
        newOption.setCorrect(correct);
        questionOptionRepository.save(newOption);
    }

    public void deleteQuestionById(String id) {
        questionOptionRepository.deleteById(id);
    }
}
