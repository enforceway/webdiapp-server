package com.webdiapp.questions.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.questionaire.service.QuestionaireQuestionService;
import com.webdiapp.questions.entities.Question;
import com.webdiapp.questions.mapper.QuestionDAO;
import org.springframework.stereotype.Service;

@Service
public class QuestionsServiceImpl implements QuestionaireQuestionService.QuestionsService {

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
		return this.questionDao.getCount();
	}

	@Override
	public int insert(Question question) {
		return this.questionDao.insert(question);
	}

	@Override
	public int delete(int id) {
		return this.questionDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Question question) {
		return this.questionDao.update(question);
	}
    
}