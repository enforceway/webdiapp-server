package com.webdiapp.user.vo;

import java.util.ArrayList;
import java.util.List;

public class UserRolesVO {

	private Integer id;
	private String username;
	private List<RoleVO> roles;

	private UserRolesVO() {
	}

	public static UserRolesVO generate() {
		UserRolesVO ur = new UserRolesVO();
		ur.setRoles(new ArrayList<RoleVO>());
		return ur;
	}

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

	public List<RoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVO> roles) {
		this.roles = roles;
	}

}
