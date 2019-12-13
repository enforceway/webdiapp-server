package com.webdiapp.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.webdiapp.entities.QuestionaireQuestion;
import com.webdiapp.mapper.QuestionaireQuestionRDAO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionItemOptionService;
import com.webdiapp.services.QuestionaireQuestionService;
import com.webdiapp.util.JsonUtil;
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
	public GeneralResponser<Integer> delete(int[] ids) {
		int i = this.queQuestionRDao.delete(ids);
		return new GeneralResponser.GeneralSponserBuilder<Integer>().build(1, "", "", i);
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
	 * @author enforceway
	 * @description 移除题目以及题目对应的后选项
	 */
	@Override
	public int patchManageQuestionItemsAndOptions(ArrayList<QuestionaireQuestionRVO> questionsInEffect) {
		int questionaireId = 0;
		int ids[] = new int[questionsInEffect.size()];
		Iterator<QuestionaireQuestionRVO> ite = questionsInEffect.iterator();
		int idx = 0;
		QuestionaireQuestionRVO questionRVO = null;
		while(ite.hasNext()) {
			questionRVO = ite.next();
			questionaireId = questionRVO.getQuestionaireId();
			ids[idx++] = questionRVO.getId();
		}
//		logger.info("方法patchManageQuestions中，非删除问卷题目:" + JsonUtil.intArrayToJson(ids));
		int ifUpdated = this.removeQuestionItemsAndOptions(ids, questionaireId);
		// 根据问卷id，题目id，确定需要删除的候选项目
		return ifUpdated;
	}

	@Override
	public int removeQuestionItemsAndOptions(int[] questionIds, int questionaireId) {
		logger.info("方法removeQuestionsByIdsWithout中，非删除问卷题目:" + JsonUtil.intArrayToJson(questionIds) + ", " + questionaireId);
		// 根据问卷题目id，关联制定的问卷id，移除所有的问卷题目
		int ifRemoveQuestion = this.queQuestionRDao.removeQuestionItemsByQuestionItemIds(questionIds, questionaireId);
		// 根据问卷题目id，移除所有的问卷题目候选项
		int ifRemoveQuestionItem = this.questionItemService.removeQuestionItemOptionsByQuestionItemIds(questionIds, questionaireId);
		return ifRemoveQuestion * ifRemoveQuestionItem;
	}

	@Override
	public int patchCreateQuestionItemsAndOptions(List<QuestionaireQuestionRVO> questions) {
		QuestionaireQuestion nQuestionItem = null;
		Date curDate = new Date();
		for(QuestionaireQuestionRVO questionItem : questions) {
			nQuestionItem = new QuestionaireQuestion();
			// 设置问卷id
			nQuestionItem.setQuestionaireId(questionItem.getQuestionaireId());
			// 设置题目类型
			nQuestionItem.setQuestionType(questionItem.getQuestionType());
			// 设置题目id
			nQuestionItem.setQuestionId(questionItem.getQuestionId());
			nQuestionItem.setEnabled(questionItem.getEnabled());
			
			nQuestionItem.setCreationTimestamp(curDate);
			nQuestionItem.setLastupdateTimestamp(curDate);
			
			// 插入问卷题目
			this.queQuestionRDao.insert(nQuestionItem);
			for(QuestionOptionRVO optionItem : questionItem.getOptions()) {
				// 设置生成的题目的id
				optionItem.setQuestionItemId(nQuestionItem.getId());
				optionItem.setCreationTimestamp(curDate);
				optionItem.setLastupdateTimestamp(curDate);
				this.questionItemService.insert(optionItem);
			}
		}
		
		return 1;
	}

}