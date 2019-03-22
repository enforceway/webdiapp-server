package com.webdiapp.services;

import java.util.List;
import com.webdiapp.entities.QuestionType;

public interface QuestionTypeService {

    List<QuestionType> getList(int pageNO, int size);

    QuestionType getById(int id);
    
    int getCount();

    int insert(QuestionType que);

    int delete(int id);

    int deletes(int[] ids);

    int update(QuestionType que);

}