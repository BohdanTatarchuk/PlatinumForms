package com.forms.app.service;

import com.forms.app.model.UserCreatesTest;
import com.forms.app.model.UserCreatesTestId;
import com.forms.app.repository.UserCreatesTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCreatesTestService {

    private final UserCreatesTestRepository userCreatesTestRepository;

    @Autowired
    public UserCreatesTestService(UserCreatesTestRepository userCreatesTestRepository) {
        this.userCreatesTestRepository = userCreatesTestRepository;
    }

    public void newCreation(UserCreatesTest userCreatesTest) {
        userCreatesTestRepository.save(userCreatesTest);
    }

    public void deleteCreation(UserCreatesTestId id) {
        userCreatesTestRepository.deleteById(id);
    }

    public Optional<UserCreatesTest> findCreationById(UserCreatesTestId id) {
        return userCreatesTestRepository.findById(id);
    }

    public List<UserCreatesTest> findAll() {
        return userCreatesTestRepository.findAll();
    }
}
