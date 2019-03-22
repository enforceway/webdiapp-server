package com.webdiapp.entities;

import java.util.Date;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;

public class Questionaire extends BaseEntity {

	private static final long serialVersionUID = -8552283633126138930L;

	private Integer id;

	private Integer statusId;

	private String status;

	private String workingField;

	private Date activeDateStart;

	private Date activeDateEnd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWorkingField() {
		return workingField;
	}

	public void setWorkingField(String workingField) {
		this.workingField = workingField;
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
