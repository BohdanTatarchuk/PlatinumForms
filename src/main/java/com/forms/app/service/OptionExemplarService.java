package com.forms.app.service;

import com.forms.app.model.OptionExemplar;
import com.forms.app.repository.OptionExemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionExemplarService {
    private final OptionExemplarRepository repository;

    @Autowired
    public OptionExemplarService(OptionExemplarRepository repository) {
        this.repository = repository;
    }

    public void saveExemplar(OptionExemplar OptionExemplar) {
        repository.save(OptionExemplar);
    }

    public void updateExemplar(OptionExemplar exemplar, String option_id) {
        Optional<OptionExemplar> optional = repository.findById(option_id);
        OptionExemplar oldOption;
        if (optional.isPresent()) {
            oldOption = optional.get();
            oldOption.setOption(exemplar.getOption());
            oldOption.setAnswered(exemplar.isAnswered());
            repository.save(oldOption);
        }
    }

    public List<OptionExemplar> findAllExemplars() {
        return repository.findAll();
    }

    public Optional<OptionExemplar> findSpecific(String option_id) {
        return repository.findById(option_id);
    }

    public void deleteExemplar(String option_id) {
        repository.deleteById(option_id);
    }
}
