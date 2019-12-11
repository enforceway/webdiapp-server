package com.webdiapp.services;

import com.webdiapp.vo.QuestionaireVO;
import com.webdiapp.models.GeneralResponser;
import com.webdiapp.vo.PagingVO;

public interface QuestionaireService {

	GeneralResponser<PagingVO> getList(int pageNO, int size);
	

    QuestionaireVO getById(Integer id);
    
    int getCount();

    int insert(QuestionaireVO que);

    int delete(int id);

    int deletes(int[] ids);

    int update(QuestionaireVO que);

}