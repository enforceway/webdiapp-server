package com.webdiapp.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.webdiapp.controllers.QuestionsController;
import com.webdiapp.entities.Question;
import com.webdiapp.mapper.QuestionDAO;
import com.webdiapp.vo.Pagination;
import com.webdiapp.vo.PagingVO;

@Service
public class QuestionsServiceImpl implements QuestionsService {
	
	private static final Logger log = Logger.getLogger(QuestionsController.class);

	@Resource
    QuestionDAO questionDao;

	@Override
	public PagingVO getList(String questionName, int pageNO, int pageSize) {
		if(pageNO == 0) {
			pageNO = 1;
		}
		if(pageSize == 0) {
			pageSize = 10;
		}
		int total = this.getCount(questionName);

		PagingVO questionPaging = new PagingVO();
		Pagination pagination = new Pagination();
		pagination.setCurPage(pageNO);
        pagination.setPageSize(pageSize);
        List<Question> list = null;

		pagination.setTotal(total);
		if(0 != total) {
			list = this.questionDao.getList(questionName, (pageNO - 1) * pageSize, pageSize);
		}
        questionPaging.setPagination(pagination);

        if(list == null) {
        	questionPaging.setData(new ArrayList<String>());
        } else {
        	questionPaging.setData(list);
        }
		log.info("问卷题目查询的如参: " + questionName + ", " + pageNO + ", " + pageSize);
		return questionPaging;
	}

	@Override
	public Question getById(int id) {
		return this.questionDao.getById(id);
	}

	@Override
	public int getCount(String content) {
		return this.questionDao.getCount(content);
	}

	@Override
	public int insert(Question question) {
		return this.questionDao.insert(question);
	}

	@Override
	public int delete(int id) {
		return this.questionDao.delete(id);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Question question) {
		return this.questionDao.update(question);
	}
    
}