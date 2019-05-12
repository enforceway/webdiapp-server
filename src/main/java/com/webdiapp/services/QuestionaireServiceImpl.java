package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.QuestionaireQuestionR;
import com.webdiapp.mapper.QuestionaireDAO;
import com.webdiapp.vo.QuestionaireQuestionRVO;
import com.webdiapp.vo.QuestionaireVO;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

	@Resource
    QuestionaireDAO queDao;
	
	@Resource
    QuestionaireQuestionService queQuestionService;

	@Override
	public List<QuestionaireVO> getList(int pageNO, int size) {
		List<Questionaire> res = this.queDao.getList(pageNO, size); 
		List<QuestionaireVO> res1 = new ArrayList<>(res.size());
		for (Questionaire que : res) {
			res1.add(new QuestionaireVO(que));
		}
        return res1;
	}

	@Override
	public Questionaire getById(int id) {
		return this.queDao.getById(id);
	}

	@Override
	public int getCount() {
		return this.queDao.getCount();
	}

	@Override
	public int insert(QuestionaireVO question) {
		Questionaire newQue = new Questionaire();
		Date date = new Date();
		newQue.setStatusId(question.getStatusId());
		newQue.setActiveDateStart(null);
		newQue.setActiveDateEnd(null);
		newQue.setCreationTimestamp(date);
		newQue.setCreationUser(null);
		newQue.setLastupdateTimestamp(date);
		newQue.setLastupdateUser(null);
		
		this.queDao.insert(newQue);
		
		List<QuestionaireQuestionRVO> ques = question.getQuestionsList();
		QuestionaireQuestionR queR = null;
		for(QuestionaireQuestionRVO questionR : ques) {
			queR = new QuestionaireQuestionR();
			queR.setQuestionType(questionR.getQuestionType());
			queR.setQuestionId(questionR.getQuestionId());
			queR.setQuestionaireId(questionR.getQuestionaireId());
			queR.setEnabled(questionR.getEnabled());
			this.queQuestionService.insert(queR);
//			questionR.getOptions();
		}

		return 1;
	}

	@Override
	public int delete(int id) {
		return this.queDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		return 0;
	}

	@Override
	public int update(Questionaire question) {
		return this.queDao.update(question);
	}
    
}