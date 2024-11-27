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

    public void updateUsername(String email, String newUsername) {
        Optional<UserT> user = userRepository.findById(email);

        if (user.isPresent()) {
            user.get().setUsername(newUsername);
            userRepository.save(user.get());
        }
    }

    public void updateProfilePicture(String email, String newProfilePicture) {
        Optional<UserT> user = userRepository.findById(email);

        if (user.isPresent()) {
            user.get().setPhoto(newProfilePicture);
            userRepository.save(user.get());
        }
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }
}
