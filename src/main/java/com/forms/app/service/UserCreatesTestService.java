package com.forms.app.service;

import com.forms.app.model.UserCreatesTest;
import com.forms.app.model.UserCreatesTestId;
import com.forms.app.repository.UserCreatesTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //userCreatesTestRepository.deleteById(id);
    }

    public void fíndCreationById(UserCreatesTestId id) {
        //userCreatesTestRepository.findById(id);
    }
}
