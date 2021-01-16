package com.webdiapp.question.vo;

import com.webdiapp.common.entities.BaseEntity;
import com.webdiapp.common.vo.BaseVO;
import com.webdiapp.question.entities.Question;
import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.questionaire.vo.QuestionaireVO;

import java.util.ArrayList;
import java.util.List;

public class QuestionVO extends BaseVO {

	private Integer id;
	
	private Integer questionTypeId;

	private String questionContent;

	private String questionType;
	
	public QuestionVO() {}

	public QuestionVO(Question que) {
        this.setId(que.getId());
        this.setQuestionTypeId(que.getQuestionTypeId());
        this.setQuestionContent(que.getQuestionContent());
        this.setQuestionType(que.getQuestionType());
        this.setCommonFields(que);
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public static List<QuestionVO> formatEntityListToVO(List<Question> list) {
		List<QuestionVO> resultList = new ArrayList<QuestionVO>();
		for (Question que : list){
			resultList.add(new QuestionVO(que));
		}
		return resultList;
	}

	// public void dt() {
	// Date d = new Date();
	// System.out.println(new SimpleDateFormat("yyyy-MM-dd
	// HH:mm:ss.SSS").format(d));
	// Timestamp ts = new Timestamp(d.getTime()); //Date to Timestamp
	// System.out.println(ts.toString());
	// }

}
