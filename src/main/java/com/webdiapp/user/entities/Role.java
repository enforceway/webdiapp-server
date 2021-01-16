package com.webdiapp.user.entities;

import com.webdiapp.common.entities.BaseEntity;

public class Role extends BaseEntity {

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
