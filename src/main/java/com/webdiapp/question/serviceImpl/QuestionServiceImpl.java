package com.webdiapp.question.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import com.webdiapp.common.constants.GeneralRemoveStatusEnum;
import com.webdiapp.question.entities.QuestionPagination;
import com.webdiapp.question.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdiapp.question.controllers.QuestionController;
import com.webdiapp.question.entities.Question;
import com.webdiapp.question.entities.QuestionPagination;
import com.webdiapp.question.mapper.QuestionMapper;
import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.question.service.QuestionService;
//import com.webdiapp.common.util.ContextUtil;
import com.webdiapp.common.vo.Pagination;
import com.webdiapp.common.vo.PagingVO;
//import com.webdiapp.common.vo.UserRolesVO;

@Service
public class QuestionServiceImpl implements QuestionService {

//	private static final Logger log = Logger.getLogger(QuestionsController.class);

	@Autowired
    QuestionMapper questionMapper;

	@Override
	public PagingVO<List<QuestionVO>> getList(String questionName, int pageNO, int pageSize) {
        QuestionPagination pagination = new QuestionPagination();
        pagination.setQuestionContent(questionName);
//		UserRolesVO userRolesVO = ContextUtil.getOnlineUserInfo();
		List<Question> list = null;
        List<QuestionVO> resultList = null;
		// 设置当前登录的人的id
//		if(!ContextUtil.isAdmin()) {
//			pagination1.setCreationUser(userRolesVO.getId());
//		}
		int total = this.getCount(pagination);
		if (0 != total) {
            // 设置关键字
            pagination.setPageIndex((pageNO - 1) * pageSize);
            pagination.setPageSize(pageSize);
			list = this.questionMapper.getList(pagination);
            if(list != null) {
                resultList = QuestionVO.formatEntityListToVO(list);
            }
            if(resultList == null) {
                resultList = new ArrayList<QuestionVO>();
            }
		}

		PagingVO<List<QuestionVO>> questionPaging = new PagingVO<List<QuestionVO>>();
		Pagination page = new Pagination();
        page.setCurPage(pageNO);
        page.setPageSize(pageSize);
        page.setTotal(total);
        questionPaging.setPagination(page);
        questionPaging.setList(resultList);
//		log.info("问卷题目查询的如参: " + questionName + ", " + pageNO + ", " + pageSize);
		return questionPaging;
	}

	@Override
	public QuestionVO getById(String id) {
		Question qr = this.questionMapper.getById(id);
		return new QuestionVO(qr);
	}

	@Override
	public int getCount(QuestionPagination question) {
	    int count = this.questionMapper.getCount(question);
		return count;
	}

	@Override
	public GeneralResponser<Integer> insert(Question question) {
//		UserRolesVO user = ContextUtil.getOnlineUserInfo();
//		System.out.println("当前登录的用户id:" + user.getId());
//		question.setCreationUser(user.getId());
//		int i = this.questionDao.insert(question);
//		return new GeneralResponser.GeneralSponserBuilder<Integer>().build(1, "", "", i);
		return null;
	}

	@Override
	public GeneralRemoveStatusEnum delete(int id) {
	    Question question = new Question();
	    question.setId(id);
        int count = this.questionMapper.getCount(question);
        if (count <= 0) {
            // 不存在
            return GeneralRemoveStatusEnum.NOTEXISTS;
        }

        int result = this.questionMapper.delete(id);
        if(result <= 0) {
            // 逻辑删除失败
            return GeneralRemoveStatusEnum.REMOVEFAIL;
        } else {
            // 逻辑删除成功
            return GeneralRemoveStatusEnum.REMOVESUCCESS;
        }
	}

	@Override
	public int deletes(int[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GeneralResponser<Integer> update(Question question) {
		return null;
	}
    
}