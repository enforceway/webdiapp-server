package com.webdiapp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.mapper.QuestionaireDAO;
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
		// 获取问卷详情
		Questionaire questionaire = this.queDao.getById(id);
		
		if(questionaire != null) {
			return null;
		}

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
	public int update(QuestionaireVO question) {
		Questionaire que = new Questionaire();
//		更新有效期
		que.setActiveDateStart(question.getActiveDateStart());
		que.setActiveDateEnd(question.getActiveDateEnd());
//		更新标题
		que.setTitle(question.getTitle());
		que.setId(question.getId());
		que.setStatusId(question.getStatusId());
		
		int naireUpdate = this.queDao.update(que);
		
		
		List<QuestionaireQuestionRVO> questions = question.getQuestionsList();
		if(questions.size() == 0) {
//			删除所有问题以及候选项
//			this.queQuestionService.removeAllQuestionaireQuestions();
//			this.questionItemOptionService.removeAllQuestionaireQuestionItems();
			return 1;
		}

//		删除相应的候选问题
		for(QuestionaireQuestionRVO questionRVO : questions) {
			
		}
		
//		删除相应的候选问题选项
//		for(QuestionaireQuestionRVO questionRVO : questions) {
//			
//		}
		
//		 新增相应的问题
		for(QuestionaireQuestionRVO questionRVO : questions) {
			
		}
		
//		 新增相应的问题的后选项
		for(QuestionaireQuestionRVO questionRVO : questions) {
			
		}

		

		/* 移除用户删除了的题目选项 */
		List<Integer> idArr = new ArrayList<Integer>();
		for(QuestionaireQuestionRVO questionRVO : questions) {
			if(questionRVO.getId() == null) {
				// 进行添加题目的操作 
				this.queQuestionService.insert(questionRVO);
			}
			for(QuestionOptionRVO optionRVO : questionRVO.getOptions()) {
				// 移除该题目后选项
				if(optionRVO.getId() != null && new Boolean(true).equals(optionRVO.getIfRemoved())) {
					idArr.add(optionRVO.getId());
				} else if(optionRVO.getId() != null) {
					// 不用做任何改动
				} else if(optionRVO.getId() == null && optionRVO.getIfRemoved() == null) {
					// 进行添加题目后选项的操作
					optionRVO.setQuestionItemId(questionRVO.getId());
					this.questionItemOptionService.insert(optionRVO);
				}
			}
		}
        int[] ids = idArr.stream().mapToInt(Integer::valueOf).toArray();
		this.questionItemOptionService.delete(ids);
		/* 移除用户删除了的题目选项 */

		
		
		
		
		
		
		
		return 1;
	}
    
}