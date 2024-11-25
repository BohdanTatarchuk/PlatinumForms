package com.forms.app.service;

import com.forms.app.model.UserPassesTest;
import com.forms.app.model.UserPassesTestId;
import com.forms.app.repository.UserPassesTestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPassesTestService {

    public UserPassesTestsRepository repository;

    @Autowired
    public UserPassesTestService(UserPassesTestsRepository repository) {
        this.repository = repository;
    }

    public void findPassByID(UserPassesTestId id) {
        //repository.findById(id);
    }

    public void createNewPass(UserPassesTest pass) {
        repository.save(pass);
    }

    public void updateMark(UserPassesTestId id, float newMark){
        /*Optional<UserPassesTest> pass = repository.findById(id);

        if(pass.isPresent()){
            pass.get().setMark(newMark);
        }

        repository.save(pass);*/
    }

    public void deletePass(UserPassesTestId id) {
        //repository.delete(id);
    }
}
