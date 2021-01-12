package com.webdiapp.user.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.user.service.UserService;
import com.webdiapp.user.entities.User;
import com.webdiapp.user.mapper.UserDAO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDAO userDao;

	@Override
	public List<User> getList(int pageNO, int size) {
//		int skip=(pageNO-1)*size;
        return this.userDao.getList(pageNO, size);
	}

	@Override
	public User getById(int id) {
		return this.userDao.getById(id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User user) {
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
	public int update(User user) {
		return this.userDao.update(user);
	}
    
}