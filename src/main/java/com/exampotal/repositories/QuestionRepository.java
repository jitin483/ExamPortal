package com.exampotal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exampotal.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
