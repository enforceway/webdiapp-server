package com.webdiapp.services.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.webdiapp.constants.CommonConstants;
import com.webdiapp.entities.User;
import com.webdiapp.entities.UserRoleAccess;
import com.webdiapp.mapper.UserAccessRoleDAO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.response.handler.user.impl.UserResponseEnum;
import com.webdiapp.services.UserAccessService;
import com.webdiapp.util.EncryptionUtil;
import com.webdiapp.util.JsonUtil;
import com.webdiapp.vo.RoleVO;
import com.webdiapp.vo.UserRolesVO;

@Service
public class UserAccessServiceImpl implements UserAccessService {
	
	private final Logger logger = Logger.getLogger(UserAccessServiceImpl.class);

	@Resource
	private UserAccessRoleDAO userAccessRoleDAO;
	
	@Override
	public Map<String, Object> isTrueCredentialUser(User user, List<User> userList) {
		Map<String, Object> responseMap = null;
		if(userList.size() == 1) {
			User retrievedUser = userList.get(0);
			this.logger.info("判断是否是有效的用户:" + JsonUtil.objectToJson(user) + ", " + JsonUtil.objectToJson(retrievedUser));
			if(retrievedUser != null && retrievedUser.getPwd().equals(user.getPwd()) && retrievedUser.getId() != null) {
				responseMap = UserResponseEnum.USER_FOUND.handle(user, retrievedUser);
			} else if(retrievedUser == null || retrievedUser.getId() == null) {
				responseMap = UserResponseEnum.USER_NOT_FOUND.handle(user, null);
			} else {
				responseMap = UserResponseEnum.CREDENTIAL_NOT_CORRECT.handle(user, null);
			}
		} else if(userList.size() == 0) {
			responseMap = UserResponseEnum.USER_NOT_FOUND.handle(user, null);
		}
		return responseMap;
	}

	@Override
	public GeneralResponser<Map<String, Object>> findUserByUserModel(User user, HttpSession session) {
		GeneralResponser.GeneralSponserBuilder<Map<String, Object>> builder = new GeneralResponser.GeneralSponserBuilder<Map<String, Object>>();
		user.setPwd(EncryptionUtil.getHash(user.getPwd(), "MD5"));
		List<User> userList = this.userAccessRoleDAO.findUserByUserModel(user);
		Map<String, Object> responseMap = this.isTrueCredentialUser(user, userList);
		this.logger.info("查询responseMap数据:" + JsonUtil.objectToJson(responseMap));
		if((Boolean)responseMap.get(CommonConstants.IF_SUCCESS) == true) {
			session.setAttribute(CommonConstants.LOGIN_SESSION_KEY, responseMap.get("data"));
		}
		// 如果找到了多个该用户, 即该用户是脏数据
		String code = (String)responseMap.get("code");
		String message = (String)responseMap.get("message");
		responseMap.remove(CommonConstants.CODE);
		responseMap.remove(CommonConstants.MESSAGE);
		responseMap.remove("data");
		responseMap.remove(CommonConstants.IF_SUCCESS);
		return builder.build(1, code, message, responseMap);
		// builder.build(1, "00", "查询用户角色出现错误：根据用户名和密码，不应该查询到两个用户结果", null);
	}

	@Override
	public GeneralResponser<UserRolesVO> listRoleByUser(User user) {
		List<UserRoleAccess> roleList = this.userAccessRoleDAO.listRoleByUser(user);
		UserRolesVO userRoleVo = UserRolesVO.generate();
		for(UserRoleAccess roleInst : roleList) {
			// 设置返回值中用户ID
			if(userRoleVo.getUserId() == null) {
				userRoleVo.setUserId(roleInst.getUserId());
			}
			// 设置返回值中用户名
			if(StringUtils.isEmpty(userRoleVo.getUsername()) == true) {
				userRoleVo.setUsername(roleInst.getUsername());
			}
			userRoleVo.getRoles().add(new RoleVO(roleInst.getRoleId(), roleInst.getRoleName()));
		}
		return new GeneralResponser.GeneralSponserBuilder<UserRolesVO>().build(1, "", "", userRoleVo);
	}

}
