package com.forms.app.service;

import com.forms.app.model.*;
import com.forms.app.repository.QuestionOptionRepository;
import com.forms.app.repository.QuestionRepository;
import com.forms.app.repository.TestFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private final TestFormRepository testFormRepository;
    private final QuestionRepository questionRepository;
    private final QuestionOptionRepository questionOptionRepository;

    @Autowired
    public TestService(TestFormRepository testFormRepository, QuestionRepository questionRepository, QuestionOptionRepository questionOptionRepository) {
        this.testFormRepository = testFormRepository;
        this.questionRepository = questionRepository;
        this.questionOptionRepository = questionOptionRepository;
    }

    public static TestForm mapToTestForm(TestDTO dto) {
        TestForm testForm = new TestForm();
        testForm.setName(dto.getName());
        testForm.setDescription(dto.getDescription());
        testForm.setId(dto.getId());
        testForm.setAuthorEmail(dto.getAuthorEmail());
        return testForm;
    }

    public TestDTO findTest(String testID) {
        Optional<TestForm> foundTest = testFormRepository.findById(testID);
        if (foundTest.isEmpty()) {
            System.out.println("Test not found");
            return null;
        }

        TestDTO testDTO = new TestDTO();
        testDTO.setId(foundTest.get().getId());
        testDTO.setName(foundTest.get().getName());
        testDTO.setDescription(foundTest.get().getDescription());
        testDTO.setAuthorEmail(foundTest.get().getAuthorEmail());

        List<QuestionDTO> questionDtoList = new ArrayList<>();
        List<Question> foundQuestions = questionRepository.findAllForOneTest(testID);
        for (Question question : foundQuestions) {
            questionDtoList.add(
                    new QuestionDTO(
                            question.getQuestionText(),
                            question.getQuestionType(),
                            question.getId(),
                            question.getTest(),
                            question.isObligatory(),
                            questionOptionRepository.findAllForOneQuestion(question.getId())
                    )
            );
        }
        testDTO.setQuestions(questionDtoList);

        System.out.println("TEST: \n" + testDTO.toString());
        return testDTO;
    }

    public List<TestForm> findAllByEmail(String email) {
        return testFormRepository.findAllByEmail(email);
    }

    public static List<Question> mapToQuestions(List<QuestionDTO> questionsDTO, TestForm testForm) {
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : questionsDTO) {
            Question question = new Question();
            question.setId(questionDTO.getId());
            question.setQuestionText(questionDTO.getText());
            question.setQuestionType(questionDTO.getType());
            question.setObligatory(questionDTO.isObligatory());
            question.setTest(testForm);
            questions.add(question);
        }
        return questions;
    }

    public static Question mapToQuestion(QuestionDTO dto) {
        Question question = new Question();
        question.setQuestionText(dto.getText());
        question.setId(dto.getId());
        question.setTest(dto.getTest());
        question.setObligatory(dto.isObligatory());
        question.setQuestionType(dto.getType());

        return question;
    }

    public void createTestForm(TestDTO newTest) {
        System.out.println("New test created: " + newTest.toString());
        TestForm test = mapToTestForm(newTest);
        List<QuestionOption> options = null;

        testFormRepository.save(test);

        List<QuestionDTO> questionDTOs = newTest.getQuestions();
        for (QuestionDTO dto : questionDTOs) {
            Question question = mapToQuestion(dto);
            questionRepository.save(question);
            options = dto.getOptions();
            questionOptionRepository.saveAll(options);
        }

    }

    public void deleteTestForm(String testID) {
        testFormRepository.deleteTest(testID);
    }
}
