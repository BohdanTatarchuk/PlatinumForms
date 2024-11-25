package com.forms.app.repository;

import com.forms.app.model.UserPassesTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPassesTestsRepository extends JpaRepository<UserPassesTest, String> {
}
