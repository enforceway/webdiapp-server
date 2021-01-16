package com.webdiapp.user.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.webdiapp.common.constants.CommonConstants;
import com.webdiapp.user.entities.User;
import com.webdiapp.user.entities.UserRoleAccess;
import com.webdiapp.user.mapper.UserAccessRoleMapper;
//import com.webdiapp.user.models.GeneralResponser;
import com.webdiapp.user.constants.UserResponseEnum;
import com.webdiapp.user.service.UserAccessService;
import com.webdiapp.user.ContextUtil;
import com.webdiapp.common.util.EncryptionUtil;
import com.webdiapp.roleAccess.vo.RoleVO;
import com.webdiapp.user.vo.UserRolesVO;

@Service
public class UserAccessServiceImpl implements UserAccessService {
	
//	private final Logger logger = Logger.getLogger(UserAccessServiceImpl.class);

	@Autowired
	private UserAccessRoleMapper userAccessRoleDAO;

	public Map<String, Object> isTrueCredentialUser(User user, List<User> userList) {
		Map<String, Object> responseMap = null;
		if(userList.size() == 1) {
			User retrievedUser = userList.get(0);
//			this.logger.info("判断是否是有效的用户:" + JsonUtil.objectToJson(user) + ", " + JsonUtil.objectToJson(retrievedUser));
			if(retrievedUser != null && retrievedUser.getPwd().equals(user.getPwd()) && retrievedUser.getId() != null) {
				UserRolesVO userRoleVO = this.listRoleByUser(retrievedUser);
				responseMap = UserResponseEnum.USER_FOUND.handle(user, userRoleVO);
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
	public Map<String, Object> findUserByUserModel(User user, HttpSession session) {
		user.setPwd(EncryptionUtil.getHash(user.getPwd(), "MD5"));
		List<User> userList = this.userAccessRoleDAO.findUserByUserModel(user);
		Map<String, Object> responseMap = this.isTrueCredentialUser(user, userList);
//		this.logger.info("查询responseMap数据:" + JsonUtil.objectToJson(responseMap));
		if((Boolean)responseMap.get(CommonConstants.IF_SUCCESS) == true) {
			ContextUtil.setOnlineUserInfo(session, responseMap.get("data"));
		}
		// 如果找到了多个该用户, 即该用户是脏数据
		String code = (String)responseMap.get("code");
		String message = (String)responseMap.get("message");
		responseMap.remove(CommonConstants.CODE);
		responseMap.remove(CommonConstants.MESSAGE);
		responseMap.remove("data");
		responseMap.remove(CommonConstants.IF_SUCCESS);
		return responseMap;
	}

	@Override
	public UserRolesVO listUserAndRole(User user) {
		UserRolesVO userRoleVo = this.listRoleByUser(user);
		return userRoleVo;
	}

	public UserRolesVO listRoleByUser(User user) {
		List<UserRoleAccess> roleList = this.userAccessRoleDAO.listRoleByUser(user);
		UserRolesVO userRoleVo = UserRolesVO.generate();
		for(UserRoleAccess roleInst : roleList) {
			// 设置返回值中用户ID
			if(userRoleVo.getId() == null) {
				userRoleVo.setId(roleInst.getUserId());
			}
			// 设置返回值中用户名
			if(StringUtils.isEmpty(userRoleVo.getUsername()) == true) {
				userRoleVo.setUsername(roleInst.getUsername());
			}
			userRoleVo.getRoles().add(new RoleVO(roleInst.getRoleId(), roleInst.getRoleName()));
		}
		return userRoleVo;
	}

}
