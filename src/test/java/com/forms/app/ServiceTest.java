//package com.forms.app;
//
//
//import com.forms.app.model.*;
//import com.forms.app.service.*;
//import org.junit.jupiter.api.*;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class ServiceTest {
//    @org.springframework.beans.factory.annotation.Autowired
//    private UserTService userService;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    private TestFormService testFormService;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    private QuestionService questionService;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    private QuestionOptionService questionOptionService;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    private QuestionContainsOptionService questionContainsOptionService;
//
//    @org.springframework.beans.factory.annotation.Autowired
//    private TestContainsQuestionService testContainsQuestionService;
//
//    @DisplayName("Testing user length")
//    @Tag("User_class_tests")
//    @Test
//    void UserLengthTest() {
//        UserT newUser = new UserT(
//                "dimaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                "dimaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com",
//                "password1",
//                null
//        );
//        DataIntegrityViolationException exception = assertThrows(
//                DataIntegrityViolationException.class,
//                () -> userService.createUser(newUser),
//                ""
//        );
//        assertTrue(exception.getMessage().contains("too long"));
//    }
//
//    @DisplayName("Testing option length")
//    @Test
//    @Tag("Option_class_tests")
//    void OptionLengthTest() {
//
//        QuestionOption option = new QuestionOption("whaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaat", "2df", true);
//
//        DataIntegrityViolationException exception = assertThrows(
//                DataIntegrityViolationException.class,
//                () -> questionOptionService.createOption(option),
//                ""
//        );
//        assertTrue(exception.getMessage().contains("too long"));
//    }
//
//    @DisplayName("Testing question length")
//    @Test
//    @Tag("Question_class_tests")
//    void QuestionLengthTest() {
//        Question q = new Question("1a", "孩子別 怕荊棘 赤著腳\n" +
//                "就 能尋到 珍貴\n" +
//                "你看這個 天黑 焰火有多美\n" +
//                "無需太多 的傷悲\n" +
//                "人本都在 茂盛枯萎\n" +
//                "但頑石和塊壘 也開花蕊\n" +
//                "撥開山嶺 讓她看看我\n" +
//                "告訴繁星 快些照亮我\n" +
//                "吹散烏云 用一抹藍色\n" +
//                "那就算 世界滿是荒蕪我們 抬頭就能 看見月亮\n" +
//                "在我們還是 孩子的模樣\n" +
//                "做雖千萬人 也要盛開 的孤芳\n" +
//                "別再憂傷煩惱\n" +
//                "別忘\n" +
//                "就算流淚 也要一直 奔跑", true);
//
//        DataIntegrityViolationException exception = assertThrows(
//                DataIntegrityViolationException.class,
//                () -> questionService.createQuestion(q),
//                ""
//        );
//        assertTrue(exception.getMessage().contains("too long"));
//    }
//
//    @DisplayName("Testing test length")
//    @Tag("TestForm_class_tests")
//    @Test
//    void FormLengthTest() {
//        TestForm testForm = new TestForm(
//                "Get your filthy eyeballs on me\n" +
//                        "What else am I wasting for?\n" +
//                        "Feed me all your woes and pity\n" +
//                        "I am nothing anymore (don't trip)\n" +
//                        "I'm at the bottom, it's a long way down (don't slip)\n" +
//                        "I'm on the bend, and it's a long way round (I'm sick)\n" +
//                        "Of who I am and what I'm talking about\n" +
//                        "'Cause no pretty face can save me now",
//                "Cocktail molotov",
//                "7zq97gbWFPFRRVVV87ss"
//        );
//
//        DataIntegrityViolationException exception = assertThrows(
//                DataIntegrityViolationException.class,
//                () -> testFormService.createTestForm(testForm),
//                ""
//        );
//        assertTrue(exception.getMessage().contains("too long"));
//    }
//
//    @DisplayName("Test creating user")
//    @Tag("User_class_tests")
//    @Order(1)
//    @Test
//    void testCreateNewUser() {
//        UserT newUser = new UserT(
//                "dima",
//                "dima@gmail.com",
//                "password1",
//                null
//        );
//        userService.createUser(newUser);
//
//        Optional<UserT> result = userService.findById("dima@gmail.com");
//
//        assertTrue(result.isPresent());
//        assertEquals("dima@gmail.com", result.get().getEmail());
//    }
//
//    @DisplayName("Test updating username")
//    @Tag("User_class_tests")
//    @Order(2)
//    @Test
//    void testUpdateUsername() {
//
//    }
//
//    @DisplayName("Test updating user's profile picture")
//    @Tag("User_class_tests")
//    @Order(3)
//    @Test
//    void testUpdateUserPicture() {
//
//    }
//
//    @DisplayName("Test deleting user")
//    @Tag("User_class_tests")
//    @Order(4)
//    @Test
//    void testDeleteUser() {
//        userService.deleteUser("dima@gmail.com");
//
//        Optional<UserT> result = userService.findById("dima@gmail.com");
//
//        assertFalse(result.isPresent());
//    }
//
//    @DisplayName("Test creating form")
//    @Tag("TestForm_class_tests")
//    @Order(5)
//    @Test
//    void testCreateNewForm() {
//        TestForm testForm = new TestForm(
//                "Math 11A",
//                "Lambda calculus",
//                "7zq97gbWFPFRRVVV87ss"
//        );
//        testFormService.createTestForm(testForm);
//
//        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
//
//        assertTrue(result.isPresent());
//        assertEquals("7zq97gbWFPFRRVVV87ss", result.get().getId());
//    }
//
//    @DisplayName("Test updating username")
//    @Tag("TestForm_class_tests")
//    @Order(6)
//    @Test
//    void testUpdateFormName() {
//        testFormService.updateTestName("7zq97gbWFPFRRVVV87ss", "Advanced math");
//        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
//
//        TestForm received = new TestForm();
//
//        if (result.isPresent()) {
//            received = result.get();
//        }
//
//        assertEquals("Advanced math", received.getName());
//    }
//
//    @DisplayName("Test updating user's profile picture")
//    @Tag("TestForm_class_tests")
//    @Order(7)
//    @Test
//    void testUpdateFormDescription() {
//        testFormService.updateTestDescription("7zq97gbWFPFRRVVV87ss", "not easy");
//        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
//
//        TestForm received = new TestForm();
//
//        if (result.isPresent()) {
//            received = result.get();
//        }
//
//        assertEquals("not easy", received.getDescription());
//    }
//
//    @DisplayName("Test creating question")
//    @Test
//    @Tag("Question_class_tests")
//    @Order(8)
//    void testCreateNewQuestion() {
//        Question q = new Question("1a", "text", true);
//
//        questionService.createQuestion(q);
//
//        Optional<Question> result = questionService.findById("1a");
//
//        Question received = new Question();
//
//        if (result.isPresent()) {
//            received = result.get();
//        }
//
//        assertEquals("text", received.getQuestionText());
//    }
//
//    //@DisplayName("Test updating question")
//    //@Test
//    //@Tag("Question_class_tests")
//    //@Order(9)
//    //void testUpdateQuestionText() {
//    //    questionService.updateQuestionById("1a", "AAAAAAAAA");
//    //    Optional<Question> result = questionService.findById("1a");
//    //    assertEquals("AAAAAAAAA", result.get().getQuestionText());
//    //}
//
//    @DisplayName("Test creating option")
//    @Test
//    @Tag("Question_class_tests")
//    @Order(10)
//    void testCreateNewOption() {
//        QuestionOption option = new QuestionOption("Waht", "2df", true);
//
//        questionOptionService.createOption(option);
//
//        Optional<QuestionOption> result = questionOptionService.findById("2df");
//
//        QuestionOption received = new QuestionOption();
//
//        if (result.isPresent()) {
//            received = result.get();
//        }
//
//        assertEquals("Waht", received.getText());
//    }
//
//    @DisplayName("Test updating option")
//    @Test
//    @Tag("Option_class_tests")
//    @Order(11)
//    void testUpdateOptionText() {
//        questionOptionService.updateQuestionOptionById("2df", "Yes thats it", true);
//        Optional<QuestionOption> result = questionOptionService.findById("2df");
//        assertEquals("Yes thats it", result.get().getText());
//    }
//
//    @DisplayName("Test updating option correctness")
//    @Test
//    @Tag("Option_class_tests")
//    @Order(12)
//    void testUpdateOptionCorrect() {
//        questionOptionService.updateQuestionOptionCorrectnessById("2df", false);
//        Optional<QuestionOption> result = questionOptionService.findById("2df");
//        assertFalse(result.get().getIsCorrect());
//    }
//
//    @DisplayName("Test creating questionContainsOption")
//    @Test
//    @Tag("Question_contains_option_class_tests")
//    @Order(13)
//    void testCreateNewQuestionContainsOption() {
//        QuestionContainsOptionId id =
//                new QuestionContainsOptionId("1a", "2df");
//        QuestionContainsOption q = new QuestionContainsOption(
//                id,
//                questionService.findById("1a").get(),
//                questionOptionService.findById("2df").get()
//        );
//
//
//        questionContainsOptionService.createQuestionContainsOption(q);
//
//        Optional<QuestionContainsOption> result =
//                questionContainsOptionService.findById(id);
//
//        assertTrue(result.isPresent());
//    }
//
//    @DisplayName("Test deleting questionContainsOption")
//    @Test
//    @Tag("Question_contains_option_class_tests")
//    @Order(14)
//    void testDeleteQuestionContainsOption() {
//        QuestionContainsOptionId id =
//                new QuestionContainsOptionId("1a", "2df");
//        questionContainsOptionService.deleteQuestionContainsOptionById(id);
//        Optional<QuestionContainsOption> result =
//                questionContainsOptionService.findById(id);
//        assertFalse(result.isPresent());
//    }
//
//    @DisplayName("Test creating testContainsQuestion")
//    @Test
//    @Tag("Test_contains_Question_class_tests")
//    @Order(15)
//    void testCreateNewTestContainsQuestion() {
//        TestContainsQuestionId id = new TestContainsQuestionId(
//                "7zq97gbWFPFRRVVV87ss",
//                "1a"
//        );
//
//        TestContainsQuestion testContainsQuestion = new TestContainsQuestion(
//                questionService.findById("1a").get(),
//                testFormService.findByTestID("7zq97gbWFPFRRVVV87ss").get(),
//                id
//        );
//
//        testContainsQuestionService.createTestContainsQuestion(testContainsQuestion);
//
//        Optional<TestContainsQuestion> result = testContainsQuestionService.findById(id);
//
//        assertTrue(result.isPresent());
//        assertEquals(id, result.get().getId());
//    }
//
//    @DisplayName("Test deleting testContainsQuestion")
//    @Test
//    @Tag("Test_contains_Question_class_tests")
//    @Order(16)
//    void testDeleteTestContainsQuestion() {
//        TestContainsQuestionId id =
//                new TestContainsQuestionId("7zq97gbWFPFRRVVV87ss", "1a");
//        testContainsQuestionService.deleteTestContainsQuestionById(id);
//        Optional<TestContainsQuestion> result =
//                testContainsQuestionService.findById(id);
//        assertFalse(result.isPresent());
//    }
//
//    @DisplayName("Test deleting form")
//    @Tag("TestForm_class_tests")
//    @Order(17)
//    @Test
//    void testDeleteForm() {
//        testFormService.deleteTestForm("7zq97gbWFPFRRVVV87ss");
//        Optional<TestForm> result = testFormService.findByTestID("7zq97gbWFPFRRVVV87ss");
//        assertFalse(result.isPresent());
//    }
//
//    @DisplayName("Test deleting option")
//    @Test
//    @Tag("Option_class_tests")
//    @Order(18)
//    void testDeleteOption() {
//        questionOptionService.deleteQuestionById("2df");
//        Optional<QuestionOption> result = questionOptionService.findById("2df");
//        assertFalse(result.isPresent());
//    }
//
//    @DisplayName("Test deleting question")
//    @Test
//    @Tag("Question_class_tests")
//    @Order(19)
//    void testDeleteQuestion() {
//        questionService.deleteQuestionById("1a");
//        Optional<Question> result = questionService.findById("1a");
//        assertFalse(result.isPresent());
//    }
//}
