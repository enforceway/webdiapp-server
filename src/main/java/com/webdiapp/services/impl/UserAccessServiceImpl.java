package com.webdiapp.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.webdiapp.entities.User;
import com.webdiapp.entities.UserRoleAccess;
import com.webdiapp.mapper.UserAccessRoleDAO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.UserAccessService;
import com.webdiapp.util.EncryptionUtil;
import com.webdiapp.vo.RoleVO;
import com.webdiapp.vo.UserRolesVO;

@Service
public class UserAccessServiceImpl implements UserAccessService {

	@Resource
	private UserAccessRoleDAO userAccessRoleDAO;

	@Override
	public User findUserByUserModel(User user) {
//		GeneralResponser.GeneralSponserBuilder<User> builder = new GeneralResponser.GeneralSponserBuilder<User>();
		user.setPwd(EncryptionUtil.getHash(user.getPwd(), "MD5"));
		List<User> userList = this.userAccessRoleDAO.findUserByUserModel(user);
		if(userList.size() == 1) {
			// 如果找到了该用户
			return userList.get(0);
		} else if(userList.size() == 0) {
			// 该用户在数据库不存在的话
			return user;
		}
		// 如果找到了多个该用户, 即该用户是脏数据
		return null;
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
