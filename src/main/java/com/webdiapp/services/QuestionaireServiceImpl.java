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
	public List<Questionaire> getList(int pageNO, int size) {
		List<Questionaire> res = this.queDao.getList(pageNO, size); 
		List<QuestionaireVO> res1 = new ArrayList<>(res.size());
//		for (Questionaire que : res) {
//			res1.add(new QuestionaireVO(que));
//		}
        return res;
	}

	@Override
	public QuestionaireVO getById(Integer id) {
		System.out.println("方法getById的入参:" + id);
		// 获取问卷详情
		Questionaire questionaire = this.queDao.getById(id);
		System.out.println("方法getById中查询到的问卷信息:" + JsonUtil.beanToJson(questionaire));

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
		System.out.println("方法getById中查询到的问卷题目信息:" + JsonUtil.listToJson(questions));
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
		Questionaire que = new Questionaire();
		que.setActiveDateStart(questionaire.getActiveDateStart());
		que.setActiveDateEnd(questionaire.getActiveDateEnd());
		que.setTitle(questionaire.getTitle());
		que.setId(questionaire.getId());
		que.setStatusId(questionaire.getStatusId());

		// 更新问卷
		int questionnaireUpdate = this.queDao.update(que);

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
		/* 新增问卷中的题目极其选项 */
		// 参数传入的是不需要删除的题目的id
		logger.info("questionsToUpdate.length:" + questionsToUpdate.size());
		
		int patchManage = this.queQuestionService.patchManageQuestions(questionsToUpdate);		
		// 批量创建
//		int patchCreate = this.queQuestionService.patchCreateQuestions(questionsToAdd);
		// 批量更新
//		int questionsUpdate = this.queQuestionService.patchUpdateQuestions(questionsToUpdate);
		return patchManage;
	}

}