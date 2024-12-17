package com.forms.app.repository;

import com.forms.app.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, String> {
    @Query(value =  " SELECT option_id, correct, text, q.question_id" +
                    " FROM question q " +
                    " INNER JOIN question_option qo " +
                    " ON q.question_id = qo.question_id" +
                    " WHERE q.question_id = :question_id"
                    , nativeQuery = true)
    List<QuestionOption> findAllForOneQuestion(@Param("question_id") String question_id);
}
