package com.webdiapp.roleAccess.vo;

import com.webdiapp.common.vo.BaseVO;
import com.webdiapp.roleAccess.entities.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleVO extends BaseVO {

	// 角色ID
	private Integer roleId;
	// 角色名称
	private String roleName;
	
	public RoleVO() {}
	
	public RoleVO(Role role) {
	    this.setRoleId(role.getRoleId());
	    this.setRoleName(role.getRoleName());
	    this.setCommonFields(role);
	}

    public RoleVO(Integer roleId, String roleName) {
        this.setRoleId(roleId);
        this.setRoleName(roleName);
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

	public Role toEntity() {
	    Role r = new Role();
	    r.setRoleId(this.getRoleId());
	    r.setRoleName(this.getRoleName());
	    return r;
    }

    public static List<RoleVO> formatEntityListToVO(List<Role> list) {
	    List<RoleVO> result = new ArrayList<RoleVO>();
        for(Role role : list) {
            result.add(new RoleVO(role));
        }
        return result;
    }


}
