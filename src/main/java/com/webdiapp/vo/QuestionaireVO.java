package com.webdiapp.vo;

import java.util.Date;
import java.util.List;

import com.webdiapp.entities.Questionaire;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;


public class QuestionaireVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String title;

	private Integer statusId;

	private Date activeDateStart;

	private Date activeDateEnd;
	
	private List<QuestionaireQuestionRVO> questionsList;
	
	public QuestionaireVO() {}
	
	public QuestionaireVO(Questionaire que) {
//		this.setCreationTimestamp(que.getCreationTimestamp());
//		System.out.println("que:" + que.getCreationUser());
//		this.setCreationUser(que.getCreationUser());
		
		this.setId(que.getId());
		this.setStatusId(que.getStatusId());
		this.setActiveDateStart(que.getActiveDateStart());
		this.setActiveDateEnd(que.getActiveDateEnd());
		this.setTitle(que.getTitle());
		this.setCreationTimestamp(que.getCreationTimestamp());
		this.setLastupdateTimestamp(que.getLastupdateTimestamp());
	}

	public Date getActiveDateStart() {
		return activeDateStart;
	}

	public void setActiveDateStart(Date activeDateStart) {
		this.activeDateStart = activeDateStart;
	}

	public Date getActiveDateEnd() {
		return activeDateEnd;
	}

	public void setActiveDateEnd(Date activeDateEnd) {
		this.activeDateEnd = activeDateEnd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public List<QuestionaireQuestionRVO> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<QuestionaireQuestionRVO> questionsList) {
		this.questionsList = questionsList;
	}

}
