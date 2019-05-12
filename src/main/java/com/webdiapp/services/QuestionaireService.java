package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.vo.QuestionaireVO;

public interface QuestionaireService {

    List<QuestionaireVO> getList(int pageNO, int size);

    Questionaire getById(int id);
    
    int getCount();

    int insert(QuestionaireVO que);

    int delete(int id);

    int deletes(int[] ids);

    int update(Questionaire que);

}