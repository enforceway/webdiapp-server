package com.webdiapp.questionaire.entities;

import com.webdiapp.common.entities.BaseEntity;

public class Status extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
