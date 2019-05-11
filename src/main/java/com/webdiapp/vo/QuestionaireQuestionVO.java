package com.webdiapp.vo;

import com.webdiapp.entities.BaseEntity;

public class QuestionaireQuestionVO extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer questionType; // 1代表单选，2代表多选，3代表文本输入，4代表长文本输入'
	private Integer questionId;
	private Integer questionaireId;
	private Integer enabled;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getQuestionaireId() {
		return questionaireId;
	}

	public void setQuestionaireId(Integer questionaireId) {
		this.questionaireId = questionaireId;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}
