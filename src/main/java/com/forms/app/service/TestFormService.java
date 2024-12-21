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
public class TestFormService {

    private final TestFormRepository testFormRepository;

    private final QuestionRepository questionRepository;

    private final QuestionOptionRepository questionOptionRepository;

    @Autowired
    public TestFormService(TestFormRepository testFormRepository, QuestionRepository questionRepository, QuestionOptionRepository questionOptionRepository) {
        this.testFormRepository = testFormRepository;
        this.questionRepository = questionRepository;
        this.questionOptionRepository = questionOptionRepository;
    }

    public static TestForm mapToTestForm(TestWithQuestionsDTO dto) {
        TestForm testForm = new TestForm();
        testForm.setName(dto.getName());
        testForm.setDescription(dto.getDescription());
        testForm.setId(dto.getId());
        testForm.setAuthorEmail(dto.getAuthorEmail());
        return testForm;
    }

    public Optional<TestForm> findByEmail(String email, String testID) {
        return testFormRepository.findByEmail(email, testID);
    }

    public List<TestForm> findAllByEmail(String email) {
        return testFormRepository.findAllByEmail(email);
    }

    public static List<Question> mapToQuestions(List<QuestionWithOptionsDTO> questionsDTO, TestForm testForm) {
        List<Question> questions = new ArrayList<>();
        for (QuestionWithOptionsDTO questionDTO : questionsDTO) {
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

    public static List<QuestionOption> mapToOptions(List<TrueOptionDTO> optionsDTO, Question question) {
        List<QuestionOption> options = new ArrayList<>();
        for (TrueOptionDTO optionDTO : optionsDTO) {
            QuestionOption option = new QuestionOption();
            option.setId(optionDTO.getId());
            option.setText(optionDTO.getText());
            option.setCorrect(optionDTO.isCorrect());
            option.setQuestion(question);
            options.add(option);
        }
        return options;
    }

    public static Question mapToQuestion(QuestionWithOptionsDTO dto) {
        Question question = new Question();
        question.setQuestionText(dto.getText());
        question.setId(dto.getId());
        question.setTest(dto.getTest());
        question.setObligatory(dto.isObligatory());
        question.setQuestionType(dto.getType());

        return question;
    }

    public void createTestForm(TestWithQuestionsDTO newTest) {
        System.out.println("New test created: " + newTest.toString());
        TestForm test = mapToTestForm(newTest);
        List<QuestionOption> options = null;

        testFormRepository.save(test);

        List<QuestionWithOptionsDTO> questionDTOs = newTest.getQuestions();
        for (QuestionWithOptionsDTO dto : questionDTOs) {
            Question question = mapToQuestion(dto);
            questionRepository.save(question);
            options = mapToOptions(dto.getOptions(), question);
            questionOptionRepository.saveAll(options);
        }

    }

    public void deleteTestForm(String testID) {
        testFormRepository.deleteTest(testID);
    }
}
