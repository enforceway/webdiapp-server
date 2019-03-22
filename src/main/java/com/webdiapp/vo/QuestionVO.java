package com.webdiapp.vo;

import com.webdiapp.entities.BaseEntity;

public class QuestionVO extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String questionContent;

	private String questionType;

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

	// public void dt() {
	// Date d = new Date();
	// System.out.println(new SimpleDateFormat("yyyy-MM-dd
	// HH:mm:ss.SSS").format(d));
	// Timestamp ts = new Timestamp(d.getTime()); //Date to Timestamp
	// System.out.println(ts.toString());
	// }

}
