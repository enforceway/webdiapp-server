package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Questionaire;
import com.webdiapp.vo.QuestionaireVO;

public interface QuestionaireService {

    List<Questionaire> getList(int pageNO, int size);

    QuestionaireVO getById(Integer id);
    
    int getCount();

    int insert(QuestionaireVO que);

    int delete(int id);

    int deletes(int[] ids);

    int update(QuestionaireVO que);

}