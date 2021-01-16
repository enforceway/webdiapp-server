package com.webdiapp.roleAccess.entities;

import com.webdiapp.common.entities.BaseEntity;

public class Role extends BaseEntity {

	private Integer roleId;
	private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
