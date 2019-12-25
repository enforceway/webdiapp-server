package com.webdiapp.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webdiapp.constants.CommonConstants;
import com.webdiapp.entities.User;
import com.webdiapp.vo.RoleVO;
import com.webdiapp.vo.UserRolesVO;

public class ContextUtil {

	public static final UserRolesVO getOnlineUserInfo(HttpSession session) {
		UserRolesVO user = (UserRolesVO)session.getAttribute(CommonConstants.LOGIN_SESSION_KEY);
		return user;
	}
	
	public static final UserRolesVO getOnlineUserInfo(Map<String, Object> map) {
		UserRolesVO user = (UserRolesVO)map.get(CommonConstants.LOGIN_SESSION_KEY);
		return user;
	}

	public static final boolean isAdmin(User user) {
		if(1 == user.getId()) {
			return true;
		}
		return false;
	}

	public static final boolean isAdmin(UserRolesVO user) {
		System.out.println("isAdmin UserRolesVO:" + user.getId());
		List<RoleVO> roles = user.getRoles();
		if(roles == null) {
			return false;
		} else if(user.getId() == null) {
			return false;
		} else if(roles.size() > 0 && (roles.stream().anyMatch(roleVO->{
			return "system_admin".equals(roleVO.getRoleName());
		}))) {
			return true;
		}
		return false;
	}

	public static final String getOnlineUserId(HttpSession session) {
		UserRolesVO user = ContextUtil.getOnlineUserInfo(session);
		Integer id = user.getId();
		if(id.equals(1)) {
			return "";
		}
		return id.toString();
	}
	
	public static final void setOnlineUserInfo(HttpSession session, Object data) {
		session.setAttribute(CommonConstants.LOGIN_SESSION_KEY, data);
	}
	
}
