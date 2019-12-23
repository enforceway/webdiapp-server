package com.webdiapp.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.webdiapp.entities.User;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.UserRolesVO;

public interface UserAccessService {

	Map<String, Object> isTrueCredentialUser(User user, List<User> retrievedUser);

	GeneralResponser<Map<String, Object>> findUserByUserModel(User user, HttpSession session);
	
	GeneralResponser<UserRolesVO> listRoleByUser(User user);

}