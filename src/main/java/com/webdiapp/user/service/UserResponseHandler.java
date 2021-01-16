package com.webdiapp.user.service;

import java.util.Map;

import com.webdiapp.user.entities.User;
import com.webdiapp.user.vo.UserRolesVO;

public interface UserResponseHandler {
	
	public Map<String, Object> handle(User user, UserRolesVO retrievedUser);

}
