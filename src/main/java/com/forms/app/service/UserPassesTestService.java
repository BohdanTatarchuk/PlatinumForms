package com.forms.app.service;

import com.forms.app.model.UserPassesTest;
import com.forms.app.model.UserPassesTestId;
import com.forms.app.repository.UserPassesTestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPassesTestService {

    private final UserPassesTestsRepository userPassesTestsRepository;

    @Autowired
    public UserPassesTestService(UserPassesTestsRepository userPassesTestsRepository) {
        this.userPassesTestsRepository = userPassesTestsRepository;
    }

    public Optional<UserPassesTest> findPassByID(UserPassesTestId id) {
        return userPassesTestsRepository.findById(id);
    }

    public void createNewPass(UserPassesTest pass) {
        userPassesTestsRepository.save(pass);
    }

    public void updateMark(UserPassesTestId id, float newMark){
        Optional<UserPassesTest> pass = userPassesTestsRepository.findById(id);

        if(pass.isPresent()){
            pass.get().setMark(newMark);
            userPassesTestsRepository.save(pass.get());
        }
    }

    public void deletePass(UserPassesTestId id) {
        userPassesTestsRepository.deleteById(id);
    }

    public List<UserPassesTest> findAll() {
        return userPassesTestsRepository.findAll();
    }
}
