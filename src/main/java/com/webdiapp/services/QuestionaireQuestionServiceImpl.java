package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.entities.QuestionaireQuestion;
import com.webdiapp.mapper.QuestionaireQuestionRDAO;
import com.webdiapp.vo.QuestionOptionRVO;
import com.webdiapp.vo.QuestionaireQuestionRVO;

@Service
public class QuestionaireQuestionServiceImpl implements QuestionaireQuestionService {
	
	@Resource
	private QuestionItemOptionService questionItemService;
	
	@Resource
	private QuestionaireQuestionRDAO queQuestionRDao;

	private static final Logger logger = Logger.getLogger(QuestionaireQuestionServiceImpl.class);

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

	@Override
	public int removeQuestionsByIds(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int patchCreateQuestions(ArrayList<QuestionaireQuestionRVO> questions) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int patchUpdateQuestions(ArrayList<QuestionaireQuestionRVO> questions) {
		// 需要新增的题目选项
		Iterator<QuestionaireQuestionRVO> ite = questions.iterator();
		QuestionaireQuestionRVO que = null;
		// 依次遍历所有题目对应的后选项
		while(ite.hasNext()) {
			que = ite.next();
			List<QuestionOptionRVO> options = que.getOptions();
			Iterator<QuestionOptionRVO> anoIte = options.iterator();
			int notRemovedOptionIds[] = new int[] {options.size()};
			int tmpIdx = 0;
			QuestionOptionRVO option = null;
			while(anoIte.hasNext()) {
				option = anoIte.next();
				if(option.getQuestionItemId() == null) {
					option.setQuestionItemId(que.getQuestionId());
					// 需要针对候选项进行添加
					// 有数据库操作
					this.questionItemService.insert(option);
				} else {
					// 该题目的候选项如果不在表单内，将会被删除
					notRemovedOptionIds[tmpIdx++] = option.getQuestionItemId();
				}
			}
			
			// 移除不在表单内的后选项 // 后选项没有更新的一说。直接删除和新增。
			this.questionItemService.removeQuestionItemsByQuestionId(notRemovedOptionIds, que.getId());			
		}
		
		// 需要删除的题目选项
		
		return 0;
	}

	/**
	 * 移除不在列表内的问卷题目
	 * */
	@Override
	public int patchManageQuestions(ArrayList<QuestionaireQuestionRVO> questionsInEffect) {
		int questionaireId = 0;
		int ids[] = new int[]{questionsInEffect.size()};
		Iterator<QuestionaireQuestionRVO> ite = questionsInEffect.iterator();
		int idx = 0;
		QuestionaireQuestionRVO questionRVO = null;
		while(ite.hasNext()) {
			questionRVO = ite.next();
			questionaireId = questionRVO.getQuestionaireId();
			ids[idx++] = questionRVO.getId();
		}
		// 不在ids数组中的问卷题目被移除
		int removedState = this.removeQuestionsByIdsWithout(ids);
		return removedState;
		// 根据问卷id，题目id，确定需要删除的候选项目
//		return this.questionItemService.removeQuestionItemsByQuestionaireId(ids, questionaireId);
	}

	@Override
	public int removeQuestionsByIdsWithout(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

}