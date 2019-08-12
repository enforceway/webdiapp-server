package com.webdiapp.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

public class Questionaire extends BaseEntity {

	private static final long serialVersionUID = -8552283633126138930L;

	private Integer id;
	
	private String title;

	private Integer statusId;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date activeDateStart;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date activeDateEnd;
	
	public Questionaire() {}

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

}
