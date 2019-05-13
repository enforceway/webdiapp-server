package com.webdiapp.vo;

import com.webdiapp.entities.QuestionItemOption;

public class QuestionOptionRVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer questionaireQuestionId;

	private String optionContent;

	private Integer selected;
	
	public QuestionOptionRVO() {
		
	}
	
	public QuestionOptionRVO(QuestionItemOption itemOption) {
		this.setId(itemOption.getId());
		this.setQuestionaireQuestionId(itemOption.getQuestionItemId());
		this.setOptionContent(itemOption.getOptionContent());
		this.setSelected(itemOption.getSelected());
		this.setCreationTimestamp(itemOption.getCreationTimestamp());
		this.setCreationUser(itemOption.getCreationUser());
		this.setLastupdateTimestamp(itemOption.getLastupdateTimestamp());
		this.setLastupdateUser(itemOption.getLastupdateUser());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionaireQuestionId() {
		return questionaireQuestionId;
	}

	public void setQuestionaireQuestionId(Integer questionaireQuestionId) {
		this.questionaireQuestionId = questionaireQuestionId;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

}
