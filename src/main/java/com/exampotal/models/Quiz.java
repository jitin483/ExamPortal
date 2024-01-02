package com.exampotal.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Quiz")
public class Quiz {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long qid;
private String title;
private String description;
private String maxMarks;
private String numberOfQuestions;
private Date createOn;
private boolean active=false;

@ManyToOne(fetch = FetchType.EAGER)
private Category category;

@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "quiz")
private Set<Question>question=new HashSet<>();

//Default constructor


public Quiz(Long qid, String title, String description, String maxMarks, String numberOfQuestions, Date createOn,
		boolean active, Category category, Set<Question> question) {
	super();
	this.qid = qid;
	this.title = title;
	this.description = description;
	this.maxMarks = maxMarks;
	this.numberOfQuestions = numberOfQuestions;
	this.createOn = createOn;
	this.active = active;
	this.category = category;
	this.question = question;
}

public Long getQid() {
	return qid;
}

public void setQid(Long qid) {
	this.qid = qid;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getMaxMarks() {
	return maxMarks;
}

public void setMaxMarks(String maxMarks) {
	this.maxMarks = maxMarks;
}

public String getNumberOfQuestions() {
	return numberOfQuestions;
}

public void setNumberOfQuestions(String numberOfQuestions) {
	this.numberOfQuestions = numberOfQuestions;
}

public Date getCreateOn() {
	return createOn;
}

public void setCreateOn(Date createOn) {
	this.createOn = createOn;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

public Set<Question> getQuestion() {
	return question;
}

public void setQuestion(Set<Question> question) {
	this.question = question;
}

@Override
public String toString() {
	return "Quiz [qid=" + qid + ", title=" + title + ", description=" + description + ", maxMarks=" + maxMarks
			+ ", numberOfQuestions=" + numberOfQuestions + ", createOn=" + createOn + ", active=" + active
			+ ", category=" + category + ", question=" + question + "]";
}


}
