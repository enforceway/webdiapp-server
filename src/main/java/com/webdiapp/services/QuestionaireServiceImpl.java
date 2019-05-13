package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.QuestionItemOption;
import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.QuestionaireQuestion;
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
	public QuestionaireVO getById(Integer id) {
		// 获取问卷详情
		Questionaire questionaire = this.queDao.getById(id);
		QuestionaireVO naireVO = new QuestionaireVO(questionaire);
		// 获取问卷对应题目
		System.out.println("questionaire id:" + questionaire.getId());
		List<QuestionaireQuestionRVO> questions = this.queQuestionService.getList(id);

		List<QuestionaireQuestionRVO> questionList = new ArrayList<QuestionaireQuestionRVO>(questions.size());
		naireVO.setQuestionsList(questionList);

		List<QuestionOptionRVO> questionItemOptions = null;
		for(QuestionaireQuestionRVO que : questions) {
			questionList.add(que);
			
			// 获取题目对应带候选项
			questionItemOptions = this.questionItemOptionService.getList(que.getQuestionId());
			que.setOptions(questionItemOptions);
		}
		return naireVO;
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
		newQue.setActiveDateStart(question.getActiveDateStart());
		newQue.setActiveDateEnd(question.getActiveDateEnd());
		newQue.setCreationTimestamp(date);
//		newQue.setCreationUser(null);
		newQue.setLastupdateTimestamp(date);
//		newQue.setLastupdateUser(null);
		
		this.queDao.insert(newQue);
		List<QuestionaireQuestionRVO> ques = question.getQuestionsList();
		QuestionaireQuestion queR = null;
		QuestionItemOption questionItem = null;
		for(QuestionaireQuestionRVO que : ques) {
			queR = new QuestionaireQuestion();
			queR.setQuestionType(que.getQuestionType());
			queR.setQuestionId(que.getQuestionId());
			queR.setQuestionaireId(newQue.getId());
			queR.setEnabled(que.getEnabled());
			queR.setCreationTimestamp(date);
			queR.setLastupdateTimestamp(date);
//			queR.setCreationUser(0);
//			queR.setLastupdateUser(0);
			this.queQuestionService.insert(queR);
			for(QuestionOptionRVO optionItem : que.getOptions()) {
				questionItem = new QuestionItemOption();
				questionItem.setCreationTimestamp(date);
//				questionItem.setCreationUser(0);
				questionItem.setOptionContent(optionItem.getOptionContent());
				this.questionItemOptionService.insert(optionItem);
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
	public int update(QuestionaireVO question) {
		Questionaire que = null;
		return this.queDao.update(que);
	}
    
}