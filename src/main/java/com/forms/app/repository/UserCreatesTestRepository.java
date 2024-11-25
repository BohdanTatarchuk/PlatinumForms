package com.forms.app.repository;

import com.forms.app.model.UserCreatesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCreatesTestRepository extends JpaRepository<UserCreatesTest, Integer> {

}
