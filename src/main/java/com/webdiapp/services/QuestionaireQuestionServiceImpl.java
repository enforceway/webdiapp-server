package com.webdiapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.QuestionaireQuestion;
import com.webdiapp.mapper.QuestionaireQuestionRDAO;
import com.webdiapp.vo.QuestionaireQuestionRVO;

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
	public int insert(QuestionaireQuestion entity) {
		return this.queQuestionRDao.insert(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<QuestionaireQuestionRVO> getList(int questionaireId) {
		List<QuestionaireQuestion> questions = this.queQuestionRDao.getList(questionaireId);
		List<QuestionaireQuestionRVO> questionItems = new ArrayList<>(questions.size());
		for (QuestionaireQuestion question : questions) {
			questionItems.add(new QuestionaireQuestionRVO(question));
		}
		return questionItems;
	}

	@Override
	public QuestionaireQuestion getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}