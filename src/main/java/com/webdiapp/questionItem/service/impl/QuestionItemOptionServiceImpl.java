package com.webdiapp.questionItem.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.webdiapp.questionItem.entities.QuestionItemOptionRelationships;
import com.webdiapp.questionItem.mapper.QuestionItemOptionMapper;
import com.webdiapp.questionItem.service.QuestionItemOptionService;
import com.webdiapp.questionItem.vo.QuestionOptionRVO;

import org.springframework.stereotype.Service;


@Service
public class QuestionItemOptionServiceImpl implements QuestionItemOptionService {

	@Resource
	private QuestionItemOptionMapper questionItemDao;

	@Override
	public List<QuestionOptionRVO> getList(int questionItemId) {
		List<QuestionItemOptionRelationships> rvs = this.questionItemDao.getList(questionItemId);
		List<QuestionOptionRVO> res = new ArrayList<>(rvs.size());
		for(QuestionItemOptionRelationships rvo : rvs) {
			res.add(new QuestionOptionRVO(rvo));
		}
		return res;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(QuestionOptionRVO entity) {
		QuestionItemOptionRelationships optionItem = new QuestionItemOptionRelationships();
//		optionItem.setId(entity.getId());
		optionItem.setQuestionItemId(entity.getQuestionItemId());
		optionItem.setOptionContent(entity.getOptionContent());
		optionItem.setSelected(entity.getSelected());
		
		optionItem.setCreationTimestamp(entity.getCreationTimestamp());
		optionItem.setLastupdateTimestamp(entity.getLastupdateTimestamp());
		optionItem.setCreationUser(entity.getCreationUser());
		optionItem.setLastupdateUser(entity.getLastupdateUser());
		int res = this.questionItemDao.insert(optionItem);
		entity.setId(optionItem.getId());
		return res;
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @description 删除同一个问卷下指定的问题中，所有的候选项
	 */
	@Override
	public int removeQuestionItemOptionsByQuestionItemIds(int[] questionIds, int questionaireId) {
//		logger.info("方法removeQuestionItemsByQuestionaireId中，非删除题目的候选项:" + JsonUtil.intArrayToJson(questionIds));
		return this.questionItemDao.removeQuestionItemOptionsByQuestionItemIds(questionIds, questionaireId);
	}

	@Override
	public int removeQuestionItemsByQuestionId(int[] questionItemIds, int questionId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
