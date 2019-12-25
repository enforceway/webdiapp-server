package com.webdiapp.services;

import com.webdiapp.vo.QuestionaireVO;
import com.webdiapp.entities.QuestionairePagination;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.PagingVO;

public interface QuestionaireService {

	GeneralResponser<PagingVO> getList(String subject, int pageNO, int size);

	GeneralResponser<QuestionaireVO> getById(Integer id);
    
    int getCount(QuestionairePagination pagination);

    GeneralResponser<Integer> insert(QuestionaireVO que);

    GeneralResponser<Integer> delete(int id);

    int deletes(int[] ids);

    GeneralResponser<Integer> update(QuestionaireVO que);

}