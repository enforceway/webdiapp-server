package com.webdiapp.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.mapper.QuestionaireDAO;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

	@Resource
    QuestionaireDAO queDao;

	@Override
	public List<Questionaire> getList(int pageNO, int size) {
//		int skip=(pageNO-1)*size;
        return this.queDao.getList(pageNO, size);
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
	public int insert(Questionaire question) {
		return this.queDao.insert(question);
	}

	@Override
	public int delete(int id) {
		return this.queDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Questionaire question) {
		return this.queDao.update(question);
	}
    
}