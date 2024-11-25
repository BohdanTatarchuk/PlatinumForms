package com.forms.app;


import com.forms.app.model.*;
import com.forms.app.service.*;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {

    @InjectMocks
    private UserTService userService;

    @InjectMocks
    private TestFormService testFormService;

    @InjectMocks
    private UserPassesTestService userPassesTestService;

    @InjectMocks
    private UserCreatesTestService userCreatesTestService;

    @InjectMocks
    private QuestionService questionService;

    @InjectMocks
    private QuestionOptionService questionOptionService;

    @InjectMocks
    private QuestionContainsOptionService questionContainsOptionService;

    @InjectMocks
    private TestContainsQuestionService testContainsQuestionService;


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

        //UserT newUser = new UserT(
        //        "haha",
        //        "haha@gmail.com",
        //        "password12",
        //        null
        //);

        //userService.createUser(newUser);


        Optional<UserT> result = userService.findById("haha@gmail.com");

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


///////////////////////////////////////////////////////////////////////////////////////

    @DisplayName("Test creating question")
    @Test
    @Order(1)
    void testCreateNewQuestion() {
        Question q = new Question("1a", "text");

        questionService.createQuestion(q);

        Optional<Question> result = questionService.findById("1a");

        Question received = new Question();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("text", received.getQuestionText());
    }

    @DisplayName("Test updating question")
    @Test
    @Order(2)
    void testUpdateQuestionText() {
        questionService.updateQuestionById("1a", "AAAAAAAAA");
        Optional<Question> result = questionService.findById("1a");
        assertEquals("AAAAAAAAA", result.get().getQuestionText());
    }

    @DisplayName("Test deleting question")
    @Test
    @Order(10)
    void testDeleteQuestion() {
        questionService.deleteQuestionById("1a");
        Optional<Question> result = questionService.findById("1a");
        assertFalse(result.isPresent());
    }

///////////////////////////////////////////////////////////////////////////////////////

    @DisplayName("Test creating option")
    @Test
    @Order(3)
    void testCreateNewOption() {
        QuestionOption option = new QuestionOption("Waht", "2df", true);

        questionOptionService.createOption(option);

        Optional<QuestionOption> result = questionOptionService.findById("2df");

        QuestionOption received = new QuestionOption();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("Waht", received.getText());
    }

    @DisplayName("Test updating option")
    @Test
    @Order(4)
    void testUpdateOptionText() {
        questionOptionService.updateQuestionOptionById("2df", "Yes thats it", true);
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertEquals("Yes thats it", result.get().getText());
    }

    @DisplayName("Test updating option correctness")
    @Test
    @Order(5)
    void testUpdateOptionCorrect() {
        questionOptionService.updateQuestionOptionCorrectnessById("2df", false);
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertFalse(result.get().isCorrect());
    }

    @DisplayName("Test deleting option")
    @Test
    @Order(11)
    void testDeleteOption() {
        questionOptionService.deleteQuestionById("2df");
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertFalse(result.isPresent());
    }

///////////////////////////////////////////////////////////////////////////////////////

    @DisplayName("Test creating questionContainsOption")
    @Test
    @Order(6)
    void testCreateNewQuestionContainsOption() {
        QuestionContainsOptionId id =
                new QuestionContainsOptionId("1a", "2df");
        QuestionContainsOption q = new QuestionContainsOption(
                id,
                questionService.findById("1a").get(),
                questionOptionService.findById("2df").get()
        );


        questionContainsOptionService.createQuestionContainsOption(q);

        Optional<QuestionContainsOption> result =
                questionContainsOptionService.findById(id);

        assertTrue(result.isPresent());
    }

    @DisplayName("Test deleting questionContainsOption")
    @Test
    @Order(7)
    void testDeleteQuestionContainsOption() {
        QuestionContainsOptionId id =
                new QuestionContainsOptionId("1a", "2df");
        questionContainsOptionService.deleteQuestionContainsOptionById(id);
        Optional<QuestionContainsOption> result =
                questionContainsOptionService.findById(id);
        assertFalse(result.isPresent());
    }

///////////////////////////////////////////////////////////////////////////////////////

    //@DisplayName("Test creating testContainsQuestion")
    //@Test
    //@Order(8)
    //void testCreateNewTestContainsQuestion() {
    //    TestContainsQuestionId id =
    //            new TestContainsQuestionId("hfgfl" ,"1a");
    //    TestContainsQuestion testContainsQuestion = new TestContainsQuestion(
    //            id,
    //            testFormService.findById("hfgfl").get(),
    //            questionService.findById("1a").get()
    //    );
//
//
    //    testContainsQuestionService.createTestContainsQuestion(testContainsQuestion);
//
    //    Optional<TestContainsQuestion> result =
    //            testContainsQuestionService.findById(id);
//
    //    assertTrue(result.isPresent());
    //}

    @DisplayName("Test deleting testContainsQuestion")
    @Test
    @Order(9)
    void testDeleteTestContainsQuestion() {
        TestContainsQuestionId id =
                new TestContainsQuestionId("hfgfl", "1a");
        testContainsQuestionService.deleteTestContainsQuestionById(id);
        Optional<TestContainsQuestion> result =
                testContainsQuestionService.findById(id);
        assertFalse(result.isPresent());
    }
}
