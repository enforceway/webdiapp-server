package com.webdiapp.services;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.webdiapp.entities.Question;
import com.webdiapp.mapper.QuestionDAO;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	@Resource
    QuestionDAO questionDao;

	@Override
	public List<Question> getList(int pageNO, int size) {
//		int skip=(pageNO-1)*size;
        return this.questionDao.getList(pageNO, size);
	}

	@Override
	public Question getById(int id) {
		return this.questionDao.getById(id);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Question question) {
		return this.questionDao.insert(question);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Question Question) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}