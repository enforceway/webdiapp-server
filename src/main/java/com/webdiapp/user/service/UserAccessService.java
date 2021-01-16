package com.webdiapp.user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webdiapp.user.entities.User;
import com.webdiapp.user.vo.UserRolesVO;

public interface UserAccessService {

	// 通过用户id获取用户名和密码
	Map<String, Object> findUserByUserModel(User user, HttpSession session);
	// 通过用户id获取用户角色
	UserRolesVO listUserAndRole(User user);

}