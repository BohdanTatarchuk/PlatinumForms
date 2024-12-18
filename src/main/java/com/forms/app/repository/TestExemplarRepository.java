package com.forms.app.repository;

import com.forms.app.model.TestExemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestExemplarRepository extends JpaRepository<TestExemplar, String> {
}
