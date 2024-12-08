package com.forms.app.repository;

import com.forms.app.model.TestContainsQuestion;
import com.forms.app.model.TestContainsQuestionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestContainsQuestionRepository extends JpaRepository
        <TestContainsQuestion, TestContainsQuestionId> {
}
