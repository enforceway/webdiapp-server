package com.webdiapp.response.handler.user;

import java.util.Map;

import com.webdiapp.entities.User;

public interface UserResponseHandler {
	
	public Map<String, Object> handle(User user, User retrievedUser);

}
