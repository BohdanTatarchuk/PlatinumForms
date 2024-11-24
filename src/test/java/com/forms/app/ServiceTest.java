package com.forms.app;

import com.forms.app.model.UserT;
import com.forms.app.service.UserTService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private UserTService userService;

    //@InjectMocks
    //private TestFormService testFormService;

    //@InjectMocks
    //private QuestionService questionService;

    //@InjectMocks
    //private QuestionOptionService questionOptionService;

    //@InjectMocks
    //private UserPassesTestService userPassesTestService;

    //@InjectMocks
    //private UserCreatesTestService userCreatesTestService;

    //@InjectMocks
    //private QuestionContainsOptionService questionContainsOption;

    //@InjectMocks
    //private TestContainsQuestionService testContainsQuestion;

    @DisplayName("Test creating user")
    @Test
    void testCreateNewUser() {
        //    UserT newUser = new UserT(
        //            "dima",
        //            "dima@gmail.com",
        //            "password1",
        //            null
        //    );

        //    userService.createUser(newUser);

        Optional<UserT> result = userService.findById("dima@gmail.com");

        UserT received = new UserT();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("dima@gmail.com", received.getEmail());
    }

    @DisplayName("Test updating username")
    @Test
    void testUpdateUsername() {

    }

    @DisplayName("Test updating user's profile picture")
    @Test
    void testUpdateUserPicture() {

    }

    @DisplayName("Test deleting user")
    @Test
    void testDeleteUser() {

    }


}
