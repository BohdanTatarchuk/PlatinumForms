package com.forms.app;


import com.forms.app.model.*;
import com.forms.app.service.*;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServiceTest {
    @org.springframework.beans.factory.annotation.Autowired
    private UserTService userService;

    @org.springframework.beans.factory.annotation.Autowired
    private TestFormService testFormService;

    @org.springframework.beans.factory.annotation.Autowired
    private QuestionService questionService;

    @org.springframework.beans.factory.annotation.Autowired
    private QuestionOptionService questionOptionService;

    @org.springframework.beans.factory.annotation.Autowired
    private QuestionContainsOptionService questionContainsOptionService;

    @org.springframework.beans.factory.annotation.Autowired
    private TestContainsQuestionService testContainsQuestionService;

    @DisplayName("Test creating user")
    @Tag("User class tests")
    @Order(1)
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

        assertTrue(result.isPresent());
        assertEquals("dima@gmail.com", result.get().getEmail());
    }

    @DisplayName("Test updating username")
    @Tag("User class tests")
    @Order(2)
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
    @Order(3)
    @Test
    void testUpdateUserPicture() {
        userService.updateProfilePicture("dima@gmail.com", "https://joejfoeo");

        Optional<UserT> result = userService.findById("dima@gmail.com");

        UserT received = new UserT();

        if (result.isPresent()) {
            received = result.get();
        }

        assertEquals("https://joejfoeo", received.getPhoto());
    }

    @DisplayName("Test deleting user")
    @Tag("User class tests")
    @Order(4)
    @Test
    void testDeleteUser() {
        userService.deleteUser("dima@gmail.com");

        Optional<UserT> result = userService.findById("dima@gmail.com");

        assertFalse(result.isPresent());
    }

    @DisplayName("Test creating form")
    @Tag("TestForm class tests")
    @Order(5)
    @Test
    void testCreateNewForm() {
        TestForm testForm = new TestForm(
                "Math 11A",
                "Lambda calculus",
                "7zq97gbWFPFRRVVV87ss"
        );
        testFormService.createTestForm(testForm);

        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");

        assertTrue(result.isPresent());
        assertEquals("7zq97gbWFPFRRVVV87ss", result.get().getId());
    }

    @DisplayName("Test updating username")
    @Tag("TestForm class tests")
    @Order(6)
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
    @Order(7)
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

    @DisplayName("Test creating question")
    @Test
    @Tag("Question class tests")
    @Order(8)
    void testCreateNewQuestion() {
        Question q = new Question("1a", "text", true);

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
    @Tag("Question class tests")
    @Order(9)
    void testUpdateQuestionText() {
        questionService.updateQuestionById("1a", "AAAAAAAAA");
        Optional<Question> result = questionService.findById("1a");
        assertEquals("AAAAAAAAA", result.get().getQuestionText());
    }

    @DisplayName("Test creating option")
    @Test
    @Tag("Option class tests")
    @Order(10)
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
    @Tag("Option class tests")
    @Order(11)
    void testUpdateOptionText() {
        questionOptionService.updateQuestionOptionById("2df", "Yes thats it", true);
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertEquals("Yes thats it", result.get().getText());
    }

    @DisplayName("Test updating option correctness")
    @Test
    @Tag("Option class tests")
    @Order(12)
    void testUpdateOptionCorrect() {
        questionOptionService.updateQuestionOptionCorrectnessById("2df", false);
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertFalse(result.get().getIsCorrect());
    }

    @DisplayName("Test creating questionContainsOption")
    @Test
    @Tag("Question contains option class tests")
    @Order(13)
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
    @Tag("Question contains option class tests")
    @Order(14)
    void testDeleteQuestionContainsOption() {
        QuestionContainsOptionId id =
                new QuestionContainsOptionId("1a", "2df");
        questionContainsOptionService.deleteQuestionContainsOptionById(id);
        Optional<QuestionContainsOption> result =
                questionContainsOptionService.findById(id);
        assertFalse(result.isPresent());
    }

    @DisplayName("Test creating testContainsQuestion")
    @Test
    @Tag("Test contains Question class tests")
    @Order(15)
    void testCreateNewTestContainsQuestion() {
        TestContainsQuestionId id = new TestContainsQuestionId(
                "7zq97gbWFPFRRVVV87ss",
                "1a"
        );

        TestContainsQuestion testContainsQuestion = new TestContainsQuestion(
                questionService.findById("1a").get(),
                testFormService.findByTestID("7zq97gbWFPFRRVVV87ss").get(),
                id
        );

        testContainsQuestionService.createTestContainsQuestion(testContainsQuestion);

        Optional<TestContainsQuestion> result = testContainsQuestionService.findById(id);

        assertTrue(result.isPresent());
        assertEquals(id, result.get().getId());
    }

    @DisplayName("Test deleting testContainsQuestion")
    @Test
    @Order(16)
    void testDeleteTestContainsQuestion() {
        TestContainsQuestionId id =
                new TestContainsQuestionId("7zq97gbWFPFRRVVV87ss", "1a");
        testContainsQuestionService.deleteTestContainsQuestionById(id);
        Optional<TestContainsQuestion> result =
                testContainsQuestionService.findById(id);
        assertFalse(result.isPresent());
    }

    @DisplayName("Test deleting form")
    @Tag("TestForm class tests")
    @Order(17)
    @Test
    void testDeleteForm() {
        testFormService.deleteTestForm("7zq97gbWFPFRRVVV87ss");
        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
        assertFalse(result.isPresent());
    }

    @DisplayName("Test deleting option")
    @Test
    @Tag("Option class tests")
    @Order(18)
    void testDeleteOption() {
        questionOptionService.deleteQuestionById("2df");
        Optional<QuestionOption> result = questionOptionService.findById("2df");
        assertFalse(result.isPresent());
    }

    @DisplayName("Test deleting question")
    @Test
    @Tag("Question class tests")
    @Order(19)
    void testDeleteQuestion() {
        questionService.deleteQuestionById("1a");
        Optional<Question> result = questionService.findById("1a");
        assertFalse(result.isPresent());
    }
}
