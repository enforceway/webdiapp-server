package com.webdiapp.user.mapper;

import java.util.List;

import com.webdiapp.user.entities.User;
import org.apache.ibatis.annotations.Param;

public interface UserDAO {
    
    public List<User> getList(@Param("skip") int skip, @Param("size") int size);
    
    public User getById(int id);
    
    public int getCount();
    
    public int insert(User user);
    
    public int delete(int id);
    
    public int update(User user);
    
}