package com.webdiapp.questionaire.mapper;

import java.util.List;

import com.webdiapp.questions.entities.Question;
import com.webdiapp.questionaire.entities.QuestionaireQuestion;

public interface QuestionaireQuestionRDAO {

    public List<QuestionaireQuestion> getList(int questionaireId);
    
    public Question getById(int id);
    
    public int getCount();
    
    public int insert(QuestionaireQuestion entity);
    
    public int delete(int[] ids);
    
//    public int update(Question entity);
}
