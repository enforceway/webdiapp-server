package com.webdiapp.questionaire.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.mapper.QuestionaireDAO;
import com.webdiapp.questionaire.service.QuestionaireQuestionService;
import com.webdiapp.questionaire.vo.QuestionaireQuestionRVO;
import com.webdiapp.questionaire.vo.QuestionaireVO;
import org.springframework.stereotype.Service;


import com.webdiapp.vo.QuestionOptionRVO;


@Service
public class QuestionaireServiceImpl implements QuestionaireQuestionService.QuestionaireService {

	@Resource
    QuestionaireQuestionService.QuestionItemOptionService questionItemOptionService;
	
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
		System.out.println("questionaire:" + questions.size());
		for(QuestionaireQuestionRVO que : questions) {
			questionList.add(que);
			
			// 获取题目对应带候选项
			System.out.println("que.getId():" + que.getId());
			questionItemOptions = this.questionItemOptionService.getList(que.getId());
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
		question.setId(newQue.getId());
		List<QuestionaireQuestionRVO> ques = question.getQuestionsList();
		for(QuestionaireQuestionRVO que : ques) {
			// 设置创建问卷后生成的id
			que.setQuestionaireId(newQue.getId());

			this.queQuestionService.insert(que);
			for(QuestionOptionRVO optionItem : que.getOptions()) {
				// 设置生成的题目的id
				optionItem.setQuestionItemId(que.getId());
				
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