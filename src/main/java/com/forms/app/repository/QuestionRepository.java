package com.forms.app.repository;

import com.forms.app.model.Question;
import com.forms.app.model.TestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    @Query(value =  " SELECT question_id, is_obligatory, question_text, q.test_id " +
                    " FROM test_form t" +
                    " INNER JOIN question q" +
                    " ON t.test_id = q.test_id" +
                    " WHERE q.test_id = :test_id"
                    , nativeQuery = true)
    List<Question> findAllForOneTest(@Param("test_id") String test_id);
}
