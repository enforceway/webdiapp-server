package com.webdiapp.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.webdiapp.constants.CommonConstants;
import com.webdiapp.vo.RoleVO;
import com.webdiapp.vo.UserRolesVO;

public class ContextUtil {
	
	public static final HttpSession getCurrentSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(false);
	};

	public static final UserRolesVO getOnlineUserInfo(HttpSession session) {
		UserRolesVO user = (UserRolesVO)session.getAttribute(CommonConstants.LOGIN_SESSION_KEY);
		return user;
	}
	
	public static final UserRolesVO getOnlineUserInfo() {
		HttpSession session = ContextUtil.getCurrentSession();
		UserRolesVO user = (UserRolesVO)session.getAttribute(CommonConstants.LOGIN_SESSION_KEY);
		return user;
	}
	
	public static final boolean isAdmin() {
		HttpSession session = ContextUtil.getCurrentSession();
		UserRolesVO user = ContextUtil.getOnlineUserInfo(session);
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

	public static final void setOnlineUserInfo(HttpSession session, Object data) {
		session.setAttribute(CommonConstants.LOGIN_SESSION_KEY, data);
	}
	
}
