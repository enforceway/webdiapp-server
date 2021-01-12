package com.webdiapp.questionItem.mapper;

import java.util.List;

import com.webdiapp.questionItem.entities.QuestionItemOption;

public interface QuestionItemOptionDAO {

    public List<QuestionItemOption> getList(int questionaireQuestionId);
    
//    public Question getById(int id);
    
    public int getCount();
    
    public int insert(QuestionItemOption entity);
    
    public int delete(int[] ids);
    
//    public int update(Question entity);
}
