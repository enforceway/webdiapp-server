package com.webdiapp.vo;

public class RoleVO {

	// 角色ID
	private Integer roleId;
	// 角色名称
	private String roleName;
	
	public RoleVO() {}
	
	public RoleVO(Integer roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

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
