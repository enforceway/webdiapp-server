package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Question;
import com.webdiapp.vo.PagingVO;

public interface QuestionsService {

//	int getPagingInfo(String questionName, int curPage, int pageSize);

	PagingVO getList(String questionName, int pageNo, int pageSize);

    int getCount(String questionName);

    Question getById(int id);    

    int insert(Question question);

    int delete(int id);

    int deletes(int[] ids);

    int update(Question Question);

}