package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.QuestionItemOption;
import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.QuestionaireQuestionR;
import com.webdiapp.mapper.QuestionaireDAO;
import com.webdiapp.vo.QuestionOptionRVO;
import com.webdiapp.vo.QuestionaireQuestionRVO;
import com.webdiapp.vo.QuestionaireVO;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

	@Resource
	QuestionItemOptionService questionItemOptionService;
	
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

	@SuppressWarnings("null")
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
		QuestionItemOption questionItem = null;
		for(QuestionaireQuestionRVO questionR : ques) {
			queR = new QuestionaireQuestionR();
			queR.setQuestionType(questionR.getQuestionType());
			queR.setQuestionId(questionR.getQuestionId());
			queR.setQuestionaireId(newQue.getId());
			queR.setEnabled(questionR.getEnabled());
			queR.setCreationTimestamp(date);
			queR.setLastupdateTimestamp(date);
//			queR.setCreationUser(0);
//			queR.setLastupdateUser(0);
			this.queQuestionService.insert(queR);
			System.out.println("start1 entity:" + questionR.getOptions().size());
			for(QuestionOptionRVO optionItem : questionR.getOptions()) {
				System.out.println("start entity:" + optionItem.getOptionContent());
				questionItem = new QuestionItemOption();
				questionItem.setCreationTimestamp(date);
//				questionItem.setCreationUser(0);
				questionItem.setOptionContent(optionItem.getOptionContent());
				this.questionItemOptionService.insert(questionItem);
			}
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