package com.webdiapp.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.User;
import com.webdiapp.mapper.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Resource
    UserDAO userDao;

	@Override
	public List<Question> getList(int pageNO, int size) {
//		int skip=(pageNO-1)*size;
        return this.userDao.getList(pageNO, size);
	}

	@Override
	public Question getById(int id) {
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