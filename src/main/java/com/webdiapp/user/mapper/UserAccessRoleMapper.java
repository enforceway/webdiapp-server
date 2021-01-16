package com.webdiapp.user.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webdiapp.user.entities.User;
import com.webdiapp.user.entities.UserRoleAccess;

public interface UserAccessRoleMapper {

    public List<User> findUserByUserModel(User user);

    public List<UserRoleAccess> listRoleByUser(User user);

}