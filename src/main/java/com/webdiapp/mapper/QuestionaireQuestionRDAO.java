package com.webdiapp.mapper;

import java.util.List;

import com.webdiapp.entities.QuestionaireQuestion;

import org.apache.ibatis.annotations.Param;

public interface QuestionaireQuestionRDAO {
	
	public int removeQuestionItemsByQuestionItemIds(@Param("questionsIds") int[] questionsIds, @Param("questionaireId") int questionaireId);

    public List<QuestionaireQuestion> getList(int questionaireId);
    
    public QuestionaireQuestion getById(int id);
    
    public int getCount();
    
    public int insert(QuestionaireQuestion entity);
    
    public int delete(int[] ids);

//    public int update(Question entity);
}
