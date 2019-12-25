package com.webdiapp.response.handler.user;

import java.util.Map;

import com.webdiapp.entities.User;
import com.webdiapp.vo.UserRolesVO;

public interface UserResponseHandler {
	
	public Map<String, Object> handle(User user, UserRolesVO retrievedUser);

}
