package com.exampotal.repositories;

import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exampotal.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

//	public Quiz addQuiz(Quiz Quiz);
//	
//	public Quiz updateQuiz(Quiz Quiz);
//	
//	public void deleteQuiz(Long qId);
//	
//	public Quiz getQuiz(Long qId);
//	
//	public Set<Quiz> getAllQuiz();
}
