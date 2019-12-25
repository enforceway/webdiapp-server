package com.webdiapp.services;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webdiapp.entities.User;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.UserRolesVO;

public interface UserAccessService {

	// 通过用户id获取用户名和密码
	GeneralResponser<Map<String, Object>> findUserByUserModel(User user, HttpSession session);
	// 通过用户id获取用户角色
	GeneralResponser<UserRolesVO> listUserAndRole(User user);

}