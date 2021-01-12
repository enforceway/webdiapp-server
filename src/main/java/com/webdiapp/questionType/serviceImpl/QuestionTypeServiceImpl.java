package com.webdiapp.questionType.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.questionType.entities.QuestionType;
import com.webdiapp.questionType.mapper.QuestionTypeDAO;
import com.webdiapp.questionType.service.QuestionTypeService;
import org.springframework.stereotype.Service;


@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	@Resource
	QuestionTypeDAO dao;

	@Override
	public List<QuestionType> getList(int pageNO, int size) {
//		int skip=(pageNO-1)*size;
        return this.dao.getList(pageNO, size);
	}

	@Override
	public QuestionType getById(int id) {
		return this.dao.getById(id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(QuestionType user) {
		return this.dao.insert(user);
	}

	@Override
	public int delete(int id) {
		return this.dao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(QuestionType user) {
		return this.dao.update(user);
	}
    
}