package com.exampotal.services;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exampotal.models.Question;
import com.exampotal.repositories.QuestionRepository;

/*
 * mark service of class question repository
 */
@Service
public class QuestionServiceImpl {
	/*
	 * 
	 * auto wired depedency
	 */
	 @Autowired
	    private QuestionRepository questionRepository;
	 
	 /*
	  * create set to get all question
	  */
	    public Set<Question> getAllQuestions() {
	        return new LinkedHashSet<>(this.questionRepository.findAll()) ;
	    }
      /*
       * create method to get question by id
       */
	    public Question getQuestionById(Long id) {
	        return questionRepository.findById(id).orElse(null);
	    }

	    /*
	     * this method for add questions
	     */
	    public Question createQuestion(Question question) {
	        return questionRepository.save(question);
	    }
	    /*
	     * this mwthod for update question
	     */

	    public Question updateQuestion(Question question) {
	        if (questionRepository.existsById(question.getQuesid())) {
	          //  question.setId(id);
	            return questionRepository.save(question);
	        }
	        return null;
	    }

	    /*
	     * to delete the questions
	     */
	    public void deleteQuestion(Long id) {
	        questionRepository.deleteById(id);
	    }
}
