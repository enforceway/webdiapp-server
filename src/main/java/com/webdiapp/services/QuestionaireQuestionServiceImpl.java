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
	public int insert(QuestionaireQuestionRVO entity) {
		QuestionaireQuestion qr = new QuestionaireQuestion();
//		qr.setId(entity.getId());
		qr.setQuestionType(entity.getQuestionType());
		qr.setQuestionaireId(entity.getQuestionaireId());
		qr.setQuestionId(entity.getQuestionId());
		qr.setEnabled(entity.getEnabled());
		
		qr.setCreationTimestamp(entity.getCreationTimestamp());
		qr.setCreationUser(entity.getCreationUser());
		qr.setLastupdateTimestamp(entity.getCreationTimestamp());
		qr.setLastupdateUser(entity.getLastupdateUser());
		
		int res = this.queQuestionRDao.insert(qr);
		entity.setId(qr.getId());
		return res;
	}

	@Override
	public int delete(int[] ids) {
		return this.queQuestionRDao.delete(ids);
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
	public QuestionaireQuestionRVO getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}