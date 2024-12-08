package com.forms.app.service;

import com.forms.app.model.Question;
import com.forms.app.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createQuestion(Question q) {
        questionRepository.save(q);
    }

    public Optional<Question> findById(String id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public void updateQuestion(String id, Question q) {
        if (questionRepository.findById(id).isEmpty()) {
            System.out.println("Error: User with login " + id + " not found");
            return;
        }

        Question newQuestion = questionRepository.findById(id).get();
        newQuestion.setQuestionText(q.getQuestionText());
        questionRepository.save(newQuestion);
    }

    public void deleteQuestionById(String id){
        questionRepository.deleteById(id);
    }
}
