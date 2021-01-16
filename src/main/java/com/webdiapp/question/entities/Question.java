package com.webdiapp.question.entities;

import com.webdiapp.common.entities.BaseEntity;
import com.webdiapp.question.vo.QuestionVO;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

public class Question extends BaseEntity {

	private Integer id;
	
	private Integer questionTypeId;

    private String questionContent;
    
    private String questionType;
    
    public Question() {}

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

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
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