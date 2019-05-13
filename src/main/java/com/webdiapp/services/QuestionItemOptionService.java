package com.webdiapp.services;

import java.util.List;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionItemOption;
import com.webdiapp.entities.QuestionaireQuestionR;

public interface QuestionItemOptionService {

    public List<Question> getList(int questionItemId);

//    public Question getById(int id);

    public int getCount();

    public int insert(QuestionItemOption entity);

    public int delete(int[] ids);

}
