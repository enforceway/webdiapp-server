package com.webdiapp.services;

import java.util.List;
import com.webdiapp.entities.Question;

public interface QuestionsService {

    List<Question> getList(int pageNO, int size);

    Question getQuestionById(int id);
    
    int getCount();

    int insert(Question question);

    int delete(int id);

    int deletes(int[] ids);

    int update(Question Question);

}