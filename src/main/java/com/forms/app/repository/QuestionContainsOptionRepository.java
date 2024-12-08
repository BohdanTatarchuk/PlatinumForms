package com.forms.app.repository;

import com.forms.app.model.QuestionContainsOption;
import com.forms.app.model.QuestionContainsOptionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionContainsOptionRepository extends JpaRepository
        <QuestionContainsOption, QuestionContainsOptionId> {
}
