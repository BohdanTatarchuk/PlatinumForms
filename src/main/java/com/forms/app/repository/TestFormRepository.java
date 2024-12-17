package com.forms.app.repository;

import com.forms.app.model.TestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestFormRepository extends JpaRepository<TestForm, String> {

    @Query(value =  " SELECT *" +
                    " FROM test_form" +
                    " WHERE author_email = :email", nativeQuery = true)
    List<TestForm> findAllByEmail(@Param("email") String email);

    @Query(value =  " SELECT * " +
                    " FROM test_form" +
                    " WHERE author_email = :email" +
                    " AND test_id = :test_id", nativeQuery = true)
    Optional<TestForm> findByEmail(@Param("email") String email, @Param("test_id") String test_id);
}
