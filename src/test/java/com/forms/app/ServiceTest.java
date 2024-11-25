package com.forms.app;

import com.forms.app.model.TestForm;
import com.forms.app.model.UserCreatesTest;
import com.forms.app.model.UserCreatesTestId;
import com.forms.app.model.UserT;
import com.forms.app.service.TestFormService;
import com.forms.app.service.UserCreatesTestService;
import com.forms.app.service.UserPassesTestService;
import com.forms.app.service.UserTService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import static org.aspectj.bridge.Version.getTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ServiceTest {

    @InjectMocks
    private UserTService userService;

    @InjectMocks
    private TestFormService testFormService;

    @InjectMocks
    private UserPassesTestService userPassesTestService;

    @InjectMocks
    private UserCreatesTestService userCreatesTestService;

    //@InjectMocks
    //private QuestionService questionService;

    //@InjectMocks
    //private QuestionOptionService questionOptionService;

    //@InjectMocks
    //private QuestionContainsOptionService questionContainsOption;

    //@InjectMocks
    //private TestContainsQuestionService testContainsQuestion;




    /*
     *
     *
     *  USER CLASS TESTS
     *
     *
     */

    @DisplayName("Test creating user")
    @Tag("User class tests")
    @Test
    void testCreateNewUser() {
        UserT newUser = new UserT(
                "dima",
                "dima@gmail.com",
                "password1",
                null
        );

        userService.createUser(newUser);

        Optional<UserT> result = userService.findById("dima@gmail.com");

        UserT received = new UserT();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals(newUser, received);
    }

    @DisplayName("Test updating username")
    @Tag("User class tests")
    @Test
    void testUpdateUsername() {
        userService.updateUsername("dima@gmail.com", "Dimasik");

        Optional<UserT> result = userService.findById("dima@gmail.com");

        UserT received = new UserT();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("Dimasik", received.getUsername());
    }

    @DisplayName("Test updating user's profile picture")
    @Tag("User class tests")
    @Test
    void testUpdateUserPicture() {
        userService.updateProfilePicture("dima@gmail.com", "https://joejfoeo");

        Optional<UserT> result = userService.findById("dima@gmail.com");

        UserT received = new UserT();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("https://joejfoeo", received.getUsername());
    }

    @DisplayName("Test deleting user")
    @Tag("User class tests")
    @Test
    void testDeleteUser() {
        userService.deleteUser("dima@gmail.com");

        Optional<UserT> result = userService.findById("dima@gmail.com");

        assertNull(result.get());
    }

    /*
     *
     *
     *  TEST FORM CLASS TESTS
     *
     *
     */

    @DisplayName("Test creating form")
    @Tag("TestForm class tests")
    @Test
    void testCreateNewForm() {
        TestForm testForm = new TestForm(
                "Math 11A",
                "Lambda calculus",
                "7zq97gbWFPFRRVVV87ss"
        );

        testFormService.createTestForm(testForm);

        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");

        TestForm received = new TestForm();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals(testForm, received);
    }

    @DisplayName("Test updating username")
    @Tag("TestForm class tests")
    @Test
    void testUpdateFormName() {
       testFormService.updateTestName("7zq97gbWFPFRRVVV87ss", "Advanced math");
       Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");

       TestForm received = new TestForm();

       if (result.isPresent()) {
           received = result.get();
       }

       assertEquals("Advanced math", received.getName());
    }

    @DisplayName("Test updating user's profile picture")
    @Tag("TestForm class tests")
    @Test
    void testUpdateFormDescription() {
        testFormService.updateTestDescription("7zq97gbWFPFRRVVV87ss", "not easy");
        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");

        TestForm received = new TestForm();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("not easy", received.getDescription());
    }

    @DisplayName("Test deleting form")
    @Tag("TestForm class tests")
    @Test
    void testDeleteForm() {
      testFormService.deleteTestForm("7zq97gbWFPFRRVVV87ss");
      Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
      assertNull(result.get());
    }

    /*
     *
     *
     *  USER CREATES FORM CLASS TESTS
     *
     *
     */

    @DisplayName("creation of a form")
    @Tag("UserCreatesForm class tests")
    @Test
    void testNewCreationOfForm() {
        UserCreatesTest creation = new UserCreatesTest(
                new UserCreatesTestId(
                    "max@gmail.com",
                        "iojqiuf89u",
                        new Date()
                ),
                new UserT(
                        "max",
                        "max@gmail.com",
                        "wqd98jqio",
                        null
                ),
                new TestForm(
                        "Eng",
                        "simple",
                        "iojqiuf89u"
                )
        );

        userCreatesTestService.newCreation(creation);

        //Optional<UserCreatesTest> result = userCreatesTestService.findById();
    }

    @DisplayName("delete creation of a form")
    @Tag("UserCreatesForm class tests")
    @Test
    void testDeleteCreationOfForm() {

    }

    /*
     *
     *
     *  USER PASSES FORM CLASS TESTS
     *
     *
     */

    @DisplayName("pass of a form")
    @Tag("UserPassesTest class tests")
    @Test
    void testNewPassOfForm() {

    }

    @DisplayName("delete pass of a form")
    @Tag("UserPassesTest class tests")
    @Test
    void testDeletePassOfForm() {

    }

}
