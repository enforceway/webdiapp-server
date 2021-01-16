package com.webdiapp.user.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import com.webdiapp.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdiapp.user.entities.User;
import com.webdiapp.user.mapper.UserMapper;
import com.webdiapp.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userDao;

	@Override
	public PagingVO<List<UserVO>> getList(int pageNO, int size) {
        PagingVO<List<UserVO>> pagingData = new PagingVO<List<UserVO>>();
        List<UserVO> resultList = null;
        int total = this.getCount(new UserVO());
		if(total > 0) {
            int npageNo = size * (pageNO - 1);
            List<User> list = this.userDao.getList(npageNo, size);
            resultList = UserVO.formatEntityListToVO(list);
        } else {
            pageNO = 0;
        }
        Pagination pagination = new Pagination(pageNO, size, total);
        pagingData.setList(resultList);
		pagingData.setPagination(pagination);
        return pagingData;
	}

	@Override
	public UserVO getById(String id) {
	    User user = this.userDao.getById(id);
		return new UserVO(user);
	}

	@Override
	public int getCount(UserVO userVO) {
	    User user = userVO.toEntity();
	    int total = this.userDao.getCount(user);
		return total;
	}

	@Override
	public int insert(UserVO userVO) {
        Date curr = new Date();
        userVO.setCreationTimestamp(curr);
        userVO.setLastupdateTimestamp(curr);
	    User user = userVO.toEntity();
		return this.userDao.insert(user);
	}

	@Override
	public int delete(int id) {
		return this.userDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserVO userVO) {
		Date curr = new Date();
		userVO.setLastupdateTimestamp(curr);
		User user = userVO.toEntity();
		return this.userDao.update(user);
	}
    
}