package com.webdiapp.user.entities;

import com.webdiapp.common.entities.BaseEntity;

public class UserRoleAccess extends BaseEntity {
	// 用户ID
	private Integer userId;
	// 用户名
	private String username;
	// 角色名
	private String roleName;
	// 角色ID
	private Integer roleId;

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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
