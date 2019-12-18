package com.webdiapp.vo;

import java.util.ArrayList;
import java.util.List;

public class UserRolesVO {

	private Integer userId;
	private String username;
	private List<RoleVO> roles;

	private UserRolesVO() {
	}

	public static UserRolesVO generate() {
		UserRolesVO ur = new UserRolesVO();
		ur.setRoles(new ArrayList<RoleVO>());
		return ur;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

}
