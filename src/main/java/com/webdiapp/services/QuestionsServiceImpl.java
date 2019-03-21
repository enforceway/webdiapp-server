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
	public Question getQuestionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Question question) {
		// TODO Auto-generated method stub
		return 0;
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