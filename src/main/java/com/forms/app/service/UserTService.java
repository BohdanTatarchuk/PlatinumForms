package com.forms.app.service;

import com.forms.app.model.UserT;
import com.forms.app.repository.UserTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserTService {

    private final UserTRepository userRepository;

    @Autowired
    public UserTService(UserTRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserT user) {
        userRepository.save(user);
    }

    public Optional<UserT> findById(String email) {
        return userRepository.findById(email);
    }
}
