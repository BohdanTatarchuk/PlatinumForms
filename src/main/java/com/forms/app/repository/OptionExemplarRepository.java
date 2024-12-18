package com.forms.app.repository;

import com.forms.app.model.OptionExemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionExemplarRepository extends JpaRepository<OptionExemplar, String> {
}
