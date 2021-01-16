package com.webdiapp.user.service;

import java.util.List;

import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.user.entities.User;
import com.webdiapp.user.vo.UserVO;

public interface UserService {

    PagingVO<List<UserVO>> getList(int pageNO, int size);

    UserVO getById(String id);
    
    int getCount(UserVO userVO);

    int insert(UserVO userVO);

    int delete(int id);

    int deletes(int[] ids);

    int update(UserVO userVO);

}