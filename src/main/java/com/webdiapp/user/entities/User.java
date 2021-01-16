package com.webdiapp.user.entities;

import com.webdiapp.common.entities.BaseEntity;

public class User extends BaseEntity {

	private Integer id;

	private String username;

	private String pwd;

	public User() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}