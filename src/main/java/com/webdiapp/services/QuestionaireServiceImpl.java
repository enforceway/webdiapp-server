package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.mapper.QuestionaireDAO;
import com.webdiapp.util.JsonUtil;
import com.webdiapp.vo.Pagination;
import com.webdiapp.vo.PagingVO;
import com.webdiapp.vo.QuestionOptionRVO;
import com.webdiapp.vo.QuestionaireQuestionRVO;
import com.webdiapp.vo.QuestionaireVO;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {

	@Resource
	QuestionItemOptionService questionItemOptionService;
	
	@Resource
    QuestionaireDAO queDao;
	
	@Resource
    QuestionaireQuestionService queQuestionService;
	
	private static final Logger logger = Logger.getLogger(QuestionaireServiceImpl.class);

	@Override
	public PagingVO getList(int pageNO, int size) {
		PagingVO questionPaging = new PagingVO();
		Pagination pagination = new Pagination();
		pagination.setCurPage(pageNO);
        pagination.setPageSize(size);
        
		List<Questionaire> res = this.queDao.getList((pageNO - 1) * size, size);
		questionPaging.setData(res);
		questionPaging.setPagination(pagination);
        return questionPaging;
	}

	@Override
	public QuestionaireVO getById(Integer id) {
		logger.info("方法getById的入参:" + id);
		// 获取问卷详情
		Questionaire questionaire = this.queDao.getById(id);
		logger.info("方法getById中查询到的问卷信息:" + JsonUtil.beanToJson(questionaire));

		QuestionaireVO naireVO = new QuestionaireVO(questionaire);
		// 获取问卷对应题目
		List<QuestionaireQuestionRVO> questions = this.queQuestionService.getList(id);

		List<QuestionaireQuestionRVO> questionList = new ArrayList<QuestionaireQuestionRVO>(questions.size());
		naireVO.setQuestionsList(questionList);

		List<QuestionOptionRVO> questionItemOptions = null;
		for(QuestionaireQuestionRVO que : questions) {
			questionList.add(que);
			// 获取题目对应带候选项
			questionItemOptions = this.questionItemOptionService.getList(que.getId());
			que.setOptions(questionItemOptions);
		}
		logger.info("方法getById中查询到的问卷题目信息:" + JsonUtil.listToJson(questions));
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
		newQue.setTitle(question.getTitle());
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
	public int update(QuestionaireVO questionaire) {
		/* 很重要:
		 * 对问卷中题目数据进行检查 
		 */
		Questionaire que = new Questionaire();
		que.setActiveDateStart(questionaire.getActiveDateStart());
		que.setActiveDateEnd(questionaire.getActiveDateEnd());
		que.setTitle(questionaire.getTitle());
		que.setId(questionaire.getId());
		que.setStatusId(questionaire.getStatusId());

		// 更新问卷
		int questionnaireUpdate = this.queDao.update(que);
		logger.info("方法update的入参:" + que + ", 问卷更新结果:" + questionnaireUpdate);

		List<QuestionaireQuestionRVO> questions = questionaire.getQuestionsList();
		// 不需要移除的题目的数组
		ArrayList<QuestionaireQuestionRVO> questionsToUpdate = new ArrayList<QuestionaireQuestionRVO>(questions.size());
		// 需要添加的题目
		ArrayList<QuestionaireQuestionRVO> questionsToAdd = new ArrayList<QuestionaireQuestionRVO>(questions.size());
		for(QuestionaireQuestionRVO questionRVO : questions) {
			if(questionRVO.getId() == null) {
				// 需要新增的题目
				questionRVO.setQuestionaireId(questionaire.getId());
				questionsToAdd.add(questionRVO);
			} else {
				// 需要更新的题目
				questionsToUpdate.add(questionRVO);
			}
		}
//		logger.info("方法update的入参，需要移除的题目候选项以及需要notin移除的问卷题目:" + JsonUtil.listToJson(questionsToUpdate));
		int patchManage = this.queQuestionService.patchManageQuestionItemsAndOptions(questionsToUpdate);
//		logger.info("方法update的入参，需要新增的题目:" + JsonUtil.listToJson(questionsToAdd));
		int patchCreate = this.queQuestionService.patchCreateQuestionItemsAndOptions(questions);
		// 批量更新
//		int questionsUpdate = this.queQuestionService.patchUpdateQuestions(questionsToUpdate);
		return questionnaireUpdate * patchManage * patchCreate;
	}

}