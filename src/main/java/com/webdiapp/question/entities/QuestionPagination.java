package com.webdiapp.question.entities;

import com.webdiapp.question.entities.Question;

public class QuestionPagination extends Question {
	
	public QuestionPagination() {}
	
	private Integer pageIndex;
	private Integer pageSize;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
