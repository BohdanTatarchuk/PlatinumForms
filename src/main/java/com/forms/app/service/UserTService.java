package com.forms.app.service;

import com.forms.app.model.UserT;
import com.forms.app.repository.UserTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTService {

    private final UserTRepository userRepository;

    @Autowired
    public UserTService(UserTRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static boolean checkPassword(String password) {
        if (password.length() < 8) {
            System.out.println("Password is too short");
            return false;
        }
        if (password.length() > 25) {
            System.out.println("Password is too long");
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

        if (!lowerChars) {
            System.out.println("No lower chars in password");
        }

        if (!numbers) {
            System.out.println("No numbers in password");
        }

        if (!upperChars) {
            System.out.println("No upper chars");
        }

        if (!specialChars) {
            System.out.println("No special chars");
        }
        return lowerChars && upperChars && numbers && specialChars;
    }

    public Optional<UserT> findById(String email) {
        return userRepository.findById(email);
    }

    public void createUser(UserT user) {
        userRepository.save(user);
    }

    public void updateUser(String email, UserT user) {
        Optional<UserT> foundUser = userRepository.findById(email);

        if (foundUser.isPresent()) {
            foundUser.get().setPhoto(user.getPhoto());
            foundUser.get().setUsername(user.getUsername());
            userRepository.save(foundUser.get());
        }
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public List<UserT> findAllUsers() {
        return userRepository.findAll();
    }
}
