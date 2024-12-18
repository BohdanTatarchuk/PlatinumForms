package com.forms.app.repository;

import com.forms.app.model.QuestionExemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionExemplarRepository extends JpaRepository<QuestionExemplar, String> {
}
