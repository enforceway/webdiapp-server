package com.webdiapp.vo;

public class QuestionOptionRVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String optionContent;

	private Boolean selected;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
