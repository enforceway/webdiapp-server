package com.webdiapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.QuestionItemOption;
import com.webdiapp.mapper.QuestionItemOptionDAO;
import com.webdiapp.vo.QuestionOptionRVO;

@Service
public class QuestionItemOptionServiceImpl implements QuestionItemOptionService {

	@Resource
	private QuestionItemOptionDAO questionItemDao;
	
	@Override
	public List<QuestionOptionRVO> getList(int questionItemId) {
		List<QuestionItemOption> rvs = this.questionItemDao.getList(questionItemId);
		List<QuestionOptionRVO> res = new ArrayList<>(rvs.size());
		for(QuestionItemOption rvo : rvs) {
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
		System.out.println("entity:" + entity.getOptionContent());
		QuestionItemOption optionItem = new QuestionItemOption();
		optionItem.setOptionContent(entity.getOptionContent());
		optionItem.setQuestionItemId(entity.getQuestionaireQuestionId());
		
		optionItem.setCreationTimestamp(entity.getCreationTimestamp());
		optionItem.setLastupdateTimestamp(entity.getLastupdateTimestamp());
		optionItem.setCreationUser(entity.getCreationUser());
		optionItem.setLastupdateUser(entity.getLastupdateUser());
		return this.questionItemDao.insert(optionItem);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
