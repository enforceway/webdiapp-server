package com.webdiapp.questionaire.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.webdiapp.questionaire.entities.Questionaire;
import com.webdiapp.common.vo.BaseVO;

//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;


public class QuestionaireVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer statusId;

	private Date activeDateStart;

	private Date activeDateEnd;
	
	private List<QuestionaireQuestionRVO> questionsList;

	private String title;
	
	public QuestionaireVO() {}

	public QuestionaireVO(Questionaire survey) {
		// 设置主键
		this.setId(survey.getId());
		// 设置状态
		this.setStatusId(survey.getStatusId());
		// 设置起始有效期
		this.setActiveDateEnd(survey.getActiveDateEnd());
		this.setActiveDateStart(survey.getActiveDateStart());
		// 设置问卷标题
        this.setTitle(survey.getTitle());
        // 设置公共信息
        this.setCommonFields(survey);
	}

	public static List<QuestionaireVO> formatEntityListToVO(List<Questionaire> list) {
		List<QuestionaireVO> resultList = new ArrayList<QuestionaireVO>();
		for (Questionaire survey : list){
			resultList.add(new QuestionaireVO(survey));
		}
		return resultList;
	}
	
//	public QuestionaireVO(Questionaire que) {
////		this.setCreationTimestamp(que.getCreationTimestamp());
////		System.out.println("que:" + que.getCreationUser());
////		this.setCreationUser(que.getCreationUser());
//
//		this.setId(que.getId());
//		this.setStatusId(que.getStatusId());
//		this.setActiveDateStart(que.getActiveDateStart());
//		this.setActiveDateEnd(que.getActiveDateEnd());
//	}

	public Date getActiveDateStart() {
		return activeDateStart;
	}

	public void setActiveDateStart(Date activeDateStart) {
		this.activeDateStart = activeDateStart;
	}

	public Date getActiveDateEnd() {
		return activeDateEnd;
	}

	public void setActiveDateEnd(Date activeDateEnd) {
		this.activeDateEnd = activeDateEnd;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public List<QuestionaireQuestionRVO> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<QuestionaireQuestionRVO> questionsList) {
		this.questionsList = questionsList;
	}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
