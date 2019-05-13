package com.webdiapp.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionaireQuestionR;
import com.webdiapp.mapper.QuestionaireQuestionRDAO;

@Service
public class QuestionaireQuestionServiceImpl implements QuestionaireQuestionService {
	
	@Resource
	private QuestionaireQuestionRDAO queQuestionRDao;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(QuestionaireQuestionR entity) {
		return this.queQuestionRDao.insert(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionaireQuestionR> getList(int questionaireId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionaireQuestionR getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
