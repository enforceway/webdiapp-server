package com.webdiapp.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.webdiapp.entities.User;
import com.webdiapp.entities.UserRoleAccess;

@Repository
public interface UserAccessDAO {

//    public List<User> findUserByUserModel(User user);

    public List<UserRoleAccess> listRoleByUser(User user);

}