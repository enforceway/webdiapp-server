package com.webdiapp.response.handler.user.impl;

import java.util.HashMap;
import java.util.Map;

import com.webdiapp.constants.CommonConstants;
import com.webdiapp.entities.User;
import com.webdiapp.response.handler.user.UserResponseHandler;
import com.webdiapp.vo.UserRolesVO;

public enum UserResponseEnum implements UserResponseHandler {
	
	USER_FOUND {
		@Override
		public Map<String, Object> handle(User user, UserRolesVO retrievedUser) {
			Map<String, Object> mapRes = new HashMap<String, Object>();
			mapRes.put(CommonConstants.CODE, "");
			mapRes.put(CommonConstants.MESSAGE, user.getUsername() +"");
			mapRes.put(CommonConstants.IF_SUCCESS, true);
			mapRes.put("data", retrievedUser);
			return mapRes;
		}
	},
	
	USER_NOT_FOUND {
		@Override
		public Map<String, Object> handle(User user, UserRolesVO retrievedUser) {
			Map<String, Object> mapRes = new HashMap<String, Object>();
			mapRes.put("code", "00");
			mapRes.put("message", user.getUsername() +": 该用户不存在");
			return mapRes;
		}
	},

	CREDENTIAL_NOT_CORRECT {
		@Override
		public Map<String, Object> handle(User user, UserRolesVO retrievedUser) {
			Map<String, Object> mapRes = new HashMap<String, Object>();
			mapRes.put("code", "00");
			mapRes.put("message", "该用户输入的密码不正确");
			return null;
		}
	}

}
