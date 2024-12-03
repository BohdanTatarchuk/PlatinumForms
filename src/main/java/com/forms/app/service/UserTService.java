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
        if(checkPassword(user.getPassword())) userRepository.save(user);
        else System.out.println("Somethjing is worng!!!!");
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

    public static boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (password.length() > 25) {
            return false;
        }

        boolean lowerChars = false;
        boolean upperChars = false;
        boolean specialChars = false;
        boolean numbers = false;

        for (int i = 0; i < password.length(); i++) {
            char test = password.charAt(i);
            if (Character.isLowerCase(test)) lowerChars = true;
            if (Character.isUpperCase(test)) upperChars = true;
            if (Character.isDigit(test)) numbers = true;
            if (test >= 33 && test <= 47 || test >= 58 && test <= 64 || test >= 91 && test <= 96 || test >= 123 && test <= 126)
                specialChars = true;
        }
        return lowerChars && upperChars && numbers && specialChars;
    }
}
