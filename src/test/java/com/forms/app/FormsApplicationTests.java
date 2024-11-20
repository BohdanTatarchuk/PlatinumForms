package com.forms.app;

import com.forms.app.model.Question;
import com.forms.app.model.TestForm;
import com.forms.app.model.User;
import com.forms.app.model.QuestionOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class FormsApplicationTests {

    @Test
    @DisplayName("Create user")
    void createNewUser() {
        User user = new User("dima",
                "dima@gmail.com",
                "782z4zgczq2r",
                "wdbcdwdwed");
    }

    @Test
    @DisplayName("Create option")
    void createNewOption() {
        QuestionOption option = new QuestionOption(
                "2",
                "hzi234rhg2wee",
                false
        );
    }

    @Test
    @DisplayName("Create question")
    void createNewQuestion() {
        Question question = new Question(
                "687awdv6vwszj",
                "What is 2 + 2?"
        );
    }

    @Test
    @DisplayName("Create Test")
    void createNewTest() {
        TestForm test = new TestForm(
                "Math 2a",
                "simple math test",
                "321487fzf79324"
        );
    }

}
