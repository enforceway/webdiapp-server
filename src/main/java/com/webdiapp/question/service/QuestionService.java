package com.webdiapp.question.service;

import com.webdiapp.common.constants.GeneralRemoveStatusEnum;
import com.webdiapp.question.entities.Question;
import com.webdiapp.question.entities.QuestionPagination;
import com.webdiapp.common.models.GeneralResponser;
import com.webdiapp.common.vo.PagingVO;
import com.webdiapp.question.vo.QuestionVO;

import java.util.List;

public interface QuestionService {

//	int getPagingInfo(String questionName, int curPage, int pageSize);

	PagingVO<List<QuestionVO>> getList(String questionName, int pageNo, int pageSize);

    int getCount(QuestionPagination pagination);

    QuestionVO getById(String id);

    GeneralResponser<Integer> insert(Question question);

    GeneralRemoveStatusEnum delete(int id);

    int deletes(int[] ids);

    GeneralResponser<Integer> update(Question Question);

}