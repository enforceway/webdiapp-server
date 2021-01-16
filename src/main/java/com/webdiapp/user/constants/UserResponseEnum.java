package com.webdiapp.user.constants;

import java.util.HashMap;
import java.util.Map;

import com.webdiapp.common.constants.CommonConstants;
import com.webdiapp.user.entities.User;
import com.webdiapp.user.service.UserResponseHandler;
import com.webdiapp.user.vo.UserRolesVO;

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
