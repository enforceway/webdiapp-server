package com.webdiapp.services;

import com.webdiapp.entities.User;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.UserRolesVO;

public interface UserAccessService {

	User findUserByUserModel(User user);
	
	GeneralResponser<UserRolesVO> listRoleByUser(User user);

}