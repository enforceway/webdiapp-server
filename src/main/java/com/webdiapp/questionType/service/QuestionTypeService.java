package com.webdiapp.questionType.service;

import java.util.List;
import com.webdiapp.questionType.entities.QuestionType;

public interface QuestionTypeService {

    List<QuestionType> getList(int pageNO, int size);

    QuestionType getById(int id);
    
    int getCount();

    int insert(QuestionType que);

    int delete(int id);

    int deletes(int[] ids);

    int update(QuestionType que);

}