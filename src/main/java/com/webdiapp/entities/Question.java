package com.webdiapp.entities;

import com.webdiapp.vo.QuestionVO;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

public class Question extends BaseEntity {

	private static final long serialVersionUID = -8552283633126138930L;

	private Integer id;

    private String questionContent;
    
    private String questionType;
    
    public Question() {
    }
    public Question(QuestionVO que) {
    	this.setQuestionContent(que.getQuestionContent());
    	this.setQuestionType(que.getQuestionType());
//    	this.setCreationTimestamp(creationTimestamp);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

}