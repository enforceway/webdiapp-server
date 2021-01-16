package com.webdiapp.roleAccess.service.impl;

import java.util.Date;
import java.util.List;

import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.roleAccess.entities.Role;
import com.webdiapp.roleAccess.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdiapp.roleAccess.mapper.RoleMapper;
import com.webdiapp.roleAccess.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
    RoleMapper roleMapper;

	@Override
	public PagingVO<List<RoleVO>> getList(int pageNO, int size) {
        PagingVO<List<RoleVO>> pagingData = new PagingVO<List<RoleVO>>();
        List<RoleVO> resultList = null;
        int total = this.getCount(new RoleVO());
		if(total > 0) {
            int npageNo = size * (pageNO - 1);
            List<Role> list = this.roleMapper.getList(npageNo, size);
            resultList = RoleVO.formatEntityListToVO(list);
        } else {
            pageNO = 0;
        }
        Pagination pagination = new Pagination(pageNO, size, total);
        pagingData.setList(resultList);
		pagingData.setPagination(pagination);
        return pagingData;
	}

	@Override
	public RoleVO getById(String id) {
	    Role user = this.roleMapper.getById(id);
		return new RoleVO(user);
	}

	@Override
	public int getCount(RoleVO roleVO) {
		Role user = roleVO.toEntity();
	    int total = this.roleMapper.getCount(user);
		return total;
	}

	@Override
	public int insert(RoleVO roleVO) {
        Date curr = new Date();
		roleVO.setCreationTimestamp(curr);
		roleVO.setLastupdateTimestamp(curr);
		Role user = roleVO.toEntity();
		return this.roleMapper.insert(user);
	}

	@Override
	public int delete(int id) {
		return this.roleMapper.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(RoleVO roleVO) {
		Date curr = new Date();
		roleVO.setLastupdateTimestamp(curr);
		Role user = roleVO.toEntity();
		return this.roleMapper.update(user);
	}
    
}