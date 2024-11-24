package com.forms.app.repository;

import com.forms.app.model.UserT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTRepository extends JpaRepository<UserT, String> {

}
