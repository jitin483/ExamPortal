package com.exampotal.services;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampotal.models.Quiz;
import com.exampotal.repositories.QuizRepository;

@Service
public class QuizServiceImpl {

    /*
     * Autowired quiz dependency
     */
    @Autowired
    private QuizRepository quizRepository;
    /*
     * to get all quiz
     */
    public Set<Quiz> getAllQuizzes() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    /*
     * get single quiz
     */
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    /*
     * create single quiz
     */
    public Quiz createQuiz(Quiz quiz) {
    	quiz.setCreateOn(new Date());
        return quizRepository.save(quiz);
    }
    /*
     * To update quiz
     */
    public Quiz updateQuiz(Quiz quiz) {
        if (quizRepository.existsById(quiz.getQid())) {
          //  quiz.setId(id);
            return quizRepository.save(quiz);
        }
        return null;
    }
    /*
     * To delete quiz
     */

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

}
