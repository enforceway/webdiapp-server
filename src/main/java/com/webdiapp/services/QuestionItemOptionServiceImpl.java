package com.webdiapp.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionItemOption;
import com.webdiapp.mapper.QuestionItemOptionDAO;

@Service
public class QuestionItemOptionServiceImpl implements QuestionItemOptionService {

	@Resource
	private QuestionItemOptionDAO questionItemDao;
	
	@Override
	public List<Question> getList(int questionaireId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(QuestionItemOption entity) {
		System.out.println("entity:" + entity.getOptionContent());
		return this.questionItemDao.insert(entity);
	}

	@Override
	public int delete(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
