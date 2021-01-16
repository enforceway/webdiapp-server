package com.webdiapp.user.vo;

import com.webdiapp.common.vo.BaseVO;
import com.webdiapp.user.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserVO extends BaseVO {
    private Integer id;

    private String username;

    public UserVO() {}

    public UserVO(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername());
        this.setCommonFields(user);
    }

    public static List<UserVO> formatEntityListToVO(List<User> list) {
        List<UserVO> resultList = new ArrayList<UserVO>();
        for(User user : list) {
            resultList.add(new UserVO(user));
        }
        return resultList;
    }

    public User toEntity() {
        User user = new User();
        if(this.getId() != null) {
            user.setId(this.getId());
        } else {
            user.setId(0);
        }
        if(this.getUsername() != null) {
            user.setUsername(this.getUsername());
        } else {
            user.setUsername("");
        }
        user.setCommonFields(this);
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
