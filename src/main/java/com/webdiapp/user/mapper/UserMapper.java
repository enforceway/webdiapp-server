package com.webdiapp.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.webdiapp.user.entities.User;

public interface UserMapper {
    
    public List<User> getList(@Param("skip") int skip,@Param("size") int size);
    
    public User getById(String id);
    
    public int getCount(User user);
    
    public int insert(User user);
    
    public int delete(int id);
    
    public int update(User user);
    
}