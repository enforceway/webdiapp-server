package com.webdiapp.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.webdiapp.controllers.QuestionsController;
import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionPagination;
import com.webdiapp.mapper.QuestionDAO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.services.QuestionsService;
import com.webdiapp.util.ContextUtil;
import com.webdiapp.vo.Pagination;
import com.webdiapp.vo.PagingVO;
import com.webdiapp.vo.UserRolesVO;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	private static final Logger log = Logger.getLogger(QuestionsController.class);

	@Resource
    QuestionDAO questionDao;

	@Override
	public GeneralResponser<PagingVO> getList(String questionName, int pageNO, int pageSize) {
		if(pageNO == 0) {
			pageNO = 1;
		}
		if(pageSize == 0) {
			pageSize = 10;
		}
		QuestionPagination pagination1 = new QuestionPagination();
		UserRolesVO userRolesVO = ContextUtil.getOnlineUserInfo();
		List<Question> list = null;
		// 设置关键字
		pagination1.setQuestionContent(questionName);
		// 设置当前登录的人的id
		if(!ContextUtil.isAdmin()) {
			pagination1.setCreationUser(userRolesVO.getId());
		}
		int total = this.getCount(pagination1);
		if(0 != total) {
			pagination1.setPageIndex((pageNO - 1) * pageSize);
			pagination1.setPageSize(pageSize);
			list = this.questionDao.getList(pagination1);
		}
		PagingVO questionPaging = new PagingVO();
		Pagination pagination = new Pagination();
		pagination.setCurPage(pageNO);
        pagination.setPageSize(pageSize);
		pagination.setTotal(total);
        questionPaging.setPagination(pagination);
        if(list == null) {
        	questionPaging.setData(new ArrayList<String>());
        } else {
        	questionPaging.setData(list);
        }
		log.info("问卷题目查询的如参: " + questionName + ", " + pageNO + ", " + pageSize);
		return new GeneralResponser.GeneralSponserBuilder<PagingVO>().build(1, "", "", questionPaging);
	}

	@Override
	public GeneralResponser<Question> getById(String id) {
		Question qr = this.questionDao.getById(id);
		return new GeneralResponser.GeneralSponserBuilder<Question>().build(1, "", "", qr);
	}

	@Override
	public int getCount(QuestionPagination content) {
		return this.questionDao.getCount(content);
	}

	@Override
	public GeneralResponser<Integer> insert(Question question) {
		UserRolesVO user = ContextUtil.getOnlineUserInfo();
		System.out.println("当前登录的用户id:" + user.getId());
		question.setCreationUser(user.getId());
		int i = this.questionDao.insert(question);
		return new GeneralResponser.GeneralSponserBuilder<Integer>().build(1, "", "", i);
	}

	@Override
	public GeneralResponser<Integer> delete(int id) {
		int i = this.questionDao.delete(id);
		return new GeneralResponser.GeneralSponserBuilder<Integer>().build(1, "", "", i);
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GeneralResponser<Integer> update(Question question) {
		int i = this.questionDao.update(question);
		return new GeneralResponser.GeneralSponserBuilder<Integer>().build(1, "", "", i);
	}
    
}