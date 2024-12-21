package com.forms.app.service;

import com.forms.app.model.QuestionExemplar;
import com.forms.app.model.TestExemplar;
import com.forms.app.repository.QuestionExemplarRepository;
import com.forms.app.repository.TestExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionExemplarService {
    private final QuestionExemplarRepository repository;

    @Autowired
    public QuestionExemplarService(QuestionExemplarRepository repository) {
        this.repository = repository;
    }

    public void saveExemplar(QuestionExemplar questionExemplar) {
        repository.save(questionExemplar);
    }

    public void updateExemplar(QuestionExemplar questionExemplar, String question_id) {
        Optional<QuestionExemplar> optional = repository.findById(question_id);
        QuestionExemplar oldQuestion;
        if (optional.isPresent()) {
            oldQuestion = optional.get();
            oldQuestion.setQuestion(questionExemplar.getQuestion());
            oldQuestion.setMark(questionExemplar.getMark());
            repository.save(oldQuestion);
        }
    }

    public List<QuestionExemplar> findAllExemplars() {
        return repository.findAll();
    }

    public Optional<QuestionExemplar> findSpecific(String question_id) {
        return repository.findById(question_id);
    }

    public void deleteExemplar(String question_id) {
        repository.deleteById(question_id);
    }
}
