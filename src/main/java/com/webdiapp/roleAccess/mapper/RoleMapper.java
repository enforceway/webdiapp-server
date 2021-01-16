package com.webdiapp.roleAccess.mapper;

import java.util.List;

import com.webdiapp.roleAccess.entities.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.webdiapp.user.entities.User;

public interface RoleMapper {
    
    public List<Role> getList(@Param("skip") int skip, @Param("size") int size);
    
    public Role getById(String id);
    
    public int getCount(Role user);
    
    public int insert(Role user);
    
    public int delete(int id);
    
    public int update(Role user);
    
}