package com.forms.app.repository;

import com.forms.app.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, String> {
}
