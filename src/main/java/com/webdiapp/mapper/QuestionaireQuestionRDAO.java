package com.webdiapp.mapper;

import java.util.List;

import com.webdiapp.entities.Question;
import com.webdiapp.entities.QuestionaireQuestion;

public interface QuestionaireQuestionRDAO {

    public List<QuestionaireQuestion> getList(int questionaireId);
    
    public Question getById(int id);
    
    public int getCount();
    
    public int insert(QuestionaireQuestion entity);
    
    public int delete(int[] ids);

//    public int update(Question entity);
}
