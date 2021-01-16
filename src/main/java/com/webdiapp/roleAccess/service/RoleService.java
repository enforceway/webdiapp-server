package com.webdiapp.roleAccess.service;

import java.util.List;

import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.roleAccess.vo.RoleVO;

public interface RoleService {

    PagingVO<List<RoleVO>> getList(int pageNO, int size);

    RoleVO getById(String id);
    
    int getCount(RoleVO roleVO);

    int insert(RoleVO roleVO);

    int delete(int id);

    int deletes(int[] ids);

    int update(RoleVO roleVO);

}