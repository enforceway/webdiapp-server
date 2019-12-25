package com.webdiapp.services;

import java.util.Map;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionPagination;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.PagingVO;

public interface QuestionsService {

//	int getPagingInfo(String questionName, int curPage, int pageSize);

	GeneralResponser<PagingVO> getList(Map<String, Object> map, String questionName, int pageNo, int pageSize);

    int getCount(QuestionPagination pagination);

    GeneralResponser<Question> getById(String id);    

    GeneralResponser<Integer> insert(Question question);

    GeneralResponser<Integer> delete(int id);

    int deletes(int[] ids);

    GeneralResponser<Integer> update(Question Question);

}