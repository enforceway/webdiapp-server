package com.webdiapp.questionaire.vo;

import java.util.List;

import com.webdiapp.common.entities.BaseEntity;
import com.webdiapp.questionItem.vo.QuestionOptionRVO;

public class QuestionaireQuestionRVO extends BaseEntity {

	private Integer id;

	private Integer questionType; // 1代表单选，2代表多选，3代表文本输入，4代表长文本输入'

	private Integer questionId;

	private Integer questionaireId;
	
	private String questionContent;

	private Integer enabled; // 1或者null代表启用状态，0代表不可用状态
	
	private List<QuestionOptionRVO> options; // 题目对应的选项
	
	public QuestionaireQuestionRVO() {}
	
	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

//	public QuestionaireQuestionRVO(QuestionaireQuestion questionR) {
//		this.setId(questionR.getId());
//		this.setQuestionType(questionR.getQuestionType());
//		this.setQuestionId(questionR.getQuestionId());
//		this.setQuestionaireId(questionR.getQuestionaireId());
//		this.setEnabled(questionR.getEnabled());
//		this.setQuestionContent(questionR.getQuestionContent());
//
//		this.setCreationTimestamp(questionR.getCreationTimestamp());
//		this.setCreationUser(questionR.getCreationUser());
//		this.setLastupdateTimestamp(questionR.getLastupdateTimestamp());
//		this.setLastupdateUser(questionR.getLastupdateUser());
//	}

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

	public List<QuestionOptionRVO> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOptionRVO> options) {
		this.options = options;
	}

}
