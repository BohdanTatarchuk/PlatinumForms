package com.forms.app.repository;

import com.forms.app.model.TestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestFormRepository extends JpaRepository<TestForm, String> {

}
