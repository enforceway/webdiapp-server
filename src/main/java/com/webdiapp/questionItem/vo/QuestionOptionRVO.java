package com.webdiapp.questionItem.vo;

import com.webdiapp.common.vo.BaseVO;
import com.webdiapp.questionItem.entities.QuestionItemOptionRelationships;

public class QuestionOptionRVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer questionItemId;

	private String optionContent;

	private Integer selected;
	
	private Boolean ifRemoved;
	
	public QuestionOptionRVO() {
		
	}
	
//	public QuestionOptionRVO(QuestionItemOption itemOption) {
//		this.setId(itemOption.getId());
//		this.setQuestionItemId(itemOption.getQuestionItemId());
//		this.setOptionContent(itemOption.getOptionContent());
//		this.setSelected(itemOption.getSelected());
//		this.setCreationTimestamp(itemOption.getCreationTimestamp());
//		this.setCreationUser(itemOption.getCreationUser());
//		this.setLastupdateTimestamp(itemOption.getLastupdateTimestamp());
//		this.setLastupdateUser(itemOption.getLastupdateUser());
//	}

	public QuestionOptionRVO(QuestionItemOptionRelationships relationships) {
		this.setId(relationships.getId());
		this.setQuestionItemId(relationships.getQuestionItemId());
		this.setOptionContent(relationships.getOptionContent());
		this.setSelected(relationships.getSelected());
		this.setCommonFields(relationships);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionItemId() {
		return questionItemId;
	}

	public void setQuestionItemId(Integer questionItemId) {
		this.questionItemId = questionItemId;
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

	public Boolean getIfRemoved() {
		return ifRemoved;
	}

	public void setIfRemoved(Boolean ifRemoved) {
		this.ifRemoved = ifRemoved;
	}

}
